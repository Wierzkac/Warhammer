const ENV = {
  dev: {
    apiUrl: 'http://localhost:8080/api'
  },
  prod: {
    apiUrl: 'https://your-production-server.com/api'
  }
};

const getEnvVars = () => {
  // You can change this to __DEV__ for React Native's development mode
  if (process.env.NODE_ENV === 'development') {
    return ENV.dev;
  }
  return ENV.prod;
};

export default getEnvVars(); 