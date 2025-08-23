import apiConfig from '../../config/api';
import { ApiError } from './errors';
import { apiCache } from './cache';
import { addAuthHeader } from './interceptors';


const request = async (endpoint, options = {}) => {
  const url = `${apiConfig.apiUrl}${endpoint}`;
  console.log('Making API request:', {
    url,
    method: options.method || 'GET',
    headers: options.headers
  });

  const defaultOptions = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  try {
    const finalOptions = await addAuthHeader({ ...defaultOptions, ...options });
    
    // Check cache for GET requests
    if (options.method === 'GET' || !options.method) {
      const cachedData = apiCache.get(url);
      if (cachedData) {
        console.log('Returning cached data for:', url);
        return cachedData;
      }
    }

    const response = await fetch(url, finalOptions);
    console.log('Response status:', response.status);

    if (!response.ok) {
      let errorMessage = `HTTP error! status: ${response.status}`;
      try {
        const errorData = await response.json();
        if (errorData.message) {
          errorMessage = errorData.message;
        }
      } catch (e) {
        // If we can't parse the error response, use the default message
      }
      throw new ApiError(errorMessage, response.status, null);
    }

    // Check if response has content before trying to parse JSON
    const contentType = response.headers.get('content-type');
    const contentLength = response.headers.get('content-length');
    
    let data = null;
    if (contentType && contentType.includes('application/json') && contentLength !== '0') {
      data = await response.json();
      console.log('Response data:', data);
    } else {
      console.log('Empty response or non-JSON content');
    }

    // Cache successful GET responses
    if ((options.method === 'GET' || !options.method) && data) {
      apiCache.set(url, data);
    }

    return data;
  } catch (error) {
    console.error('API request failed:', {
      url,
      error: error.message
    });
    throw error;
  }
};

export const api = {
  get: (endpoint, language = 'en') => {
    console.log('API.get called:', { endpoint, language });
    return request(endpoint, {
      headers: {
        'Accept-Language': language
      }
    });
  },
  post: (endpoint, data) => {
    console.log('API.post called:', { endpoint, data });
    return request(endpoint, {
      method: 'POST',
      body: JSON.stringify(data),
    });
  },
  put: (endpoint, data) => {
    console.log('API.put called:', { endpoint, data });
    return request(endpoint, {
      method: 'PUT',
      body: JSON.stringify(data),
    });
  },
  delete: (endpoint) => {
    console.log('API.delete called:', { endpoint });
    return request(endpoint, { 
      method: 'DELETE' 
    });
  },
};

// Cache management
export const clearCache = () => {
  console.log('Clearing API cache');
  apiCache.clear();
}; 