import apiConfig from '../../config/api';
import { ApiError, NetworkError } from './errors';
import { apiCache } from './cache';
import { addAuthHeader, handleResponse } from './interceptors';

// Retry logic
const withRetry = (fn, retries = 3, delay = 1000) => {
  return async (...args) => {
    let lastError;
    for (let i = 0; i < retries; i++) {
      try {
        console.log(`API call attempt ${i + 1}/${retries}`);
        const result = await fn(...args);
        console.log(`API call successful on attempt ${i + 1}`);
        return result;
      } catch (error) {
        lastError = error;
        console.warn(`API request failed (attempt ${i + 1}/${retries}):`, error);
        
        if (error instanceof NetworkError) {
          const waitTime = delay * Math.pow(2, i);
          console.log(`Retrying in ${waitTime}ms...`);
          await new Promise(resolve => setTimeout(resolve, waitTime));
          continue;
        }
        throw error;
      }
    }
    console.error('All retry attempts failed:', lastError);
    throw lastError;
  };
};

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
      throw new ApiError(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();
    console.log('Response data:', data);

    // Cache successful GET responses
    if (options.method === 'GET' || !options.method) {
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