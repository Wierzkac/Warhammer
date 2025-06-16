export const addAuthHeader = async (options) => {
  // Add auth header if needed
  const token = await getAuthToken();
  if (token) {
    return {
      ...options,
      headers: {
        ...options.headers,
        'Authorization': `Bearer ${token}`
      }
    };
  }
  return options;
};

export const handleResponse = async (response) => {
  const contentType = response.headers.get('content-type');
  
  if (contentType && contentType.includes('application/json')) {
    const data = await response.json();
    console.log('Parsed JSON response:', data);
    return data;
  }
  
  const text = await response.text();
  console.log('Raw response text:', text);
  
  try {
    const data = JSON.parse(text);
    console.log('Parsed text as JSON:', data);
    return data;
  } catch (e) {
    console.log('Response is not JSON, returning as text');
    return text;
  }
};

// Helper function to get auth token
const getAuthToken = async () => {
  // Implement your token retrieval logic here
  return null;
}; 