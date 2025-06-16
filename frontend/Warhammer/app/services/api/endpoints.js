import { api } from './client';

// Career endpoints
export const careers = {
  getAll: (language) => api.get('/careers', language),
  getById: (id, language) => api.get(`/careers/${id}`, language)
};

// Talent endpoints
export const talents = {
  getAll: (language) => api.get('/talents', language),
  getById: (id, language) => api.get(`/talents/${id}`, language)
};

// Skill endpoints
export const skills = {
  getAll: (language) => api.get('/skills', language),
  getById: (id, language) => api.get(`/skills/${id}`, language)
};

// Auth endpoints
export const auth = {
  login: (credentials) => api.post('/auth/login', credentials),
  register: (userData) => api.post('/auth/register', userData),
  logout: () => api.post('/auth/logout'),
  refreshToken: () => api.post('/auth/refresh')
};

// User endpoints
export const users = {
  getProfile: () => api.get('/users/profile'),
  updateProfile: (data) => api.put('/users/profile', data),
  changePassword: (data) => api.put('/users/password', data)
}; 