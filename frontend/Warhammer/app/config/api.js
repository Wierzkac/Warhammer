const ENV = {
  dev: {
    apiUrl: 'http://localhost:8080',
    timeout: 10000,
    cacheDuration: 30 * 60 * 1000, // 30 minutes
  },
  prod: {
    apiUrl: 'https://api.warhammer-app.com/api',
    timeout: 15000,
    cacheDuration: 30 * 60 * 1000, // 30 minutes
  }
};

const getEnvConfig = () => {
  const config = process.env.NODE_ENV === 'production' ? ENV.prod : ENV.dev;
  console.log('Using API configuration:', config);
  return config;
};

const apiConfig = getEnvConfig();

export default apiConfig; 