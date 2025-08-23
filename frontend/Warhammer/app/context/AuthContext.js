import React, { createContext, useState, useContext } from 'react';
import { auth, users } from '../services/api/endpoints';

const AuthContext = createContext(null);

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [token, setToken] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const login = async (credentials) => {
    try {
      setLoading(true);
      setError(null);
      const response = await auth.login(credentials);
      
      // Store the JWT token
      setToken(response.token);
      // Set global token for API requests
      if (typeof window !== 'undefined') {
        window.authToken = response.token;
      }
      
      // Fetch user profile data after successful login
      const userProfile = await users.getProfile();
      setUser(userProfile);
      
      return response;
    } catch (err) {
      setError(err.message);
      throw err;
    } finally {
      setLoading(false);
    }
  };

  const register = async (userData) => {
    try {
      setLoading(true);
      setError(null);
      const response = await auth.register(userData);
      console.log("response: " + JSON.stringify(response));
      
      // Store the JWT token
      setToken(response.token);
      // Set global token for API requests
      if (typeof window !== 'undefined') {
        window.authToken = response.token;
      }
      
      // Fetch user profile data after successful registration
      const userProfile = await users.getProfile();
      setUser(userProfile);
      
      return response;
    } catch (err) {
      setError(err.message);
      throw err;
    } finally {
      setLoading(false);
    }
  };

  const logout = async () => {
    try {
      setLoading(true);
      await auth.logout();
    } catch (err) {
      console.warn('Logout request failed, but clearing local state:', err.message);
      // Even if the logout request fails, we should clear local state
    } finally {
      // Always clear local state regardless of server response
      setUser(null);
      setToken(null);
      setError(null);
      // Clear global token
      if (typeof window !== 'undefined') {
        window.authToken = null;
      }
      setLoading(false);
    }
  };

  const value = {
    user,
    token,
    loading,
    error,
    login,
    register,
    logout
  };

  return (
    <AuthContext.Provider value={value}>
      {children}
    </AuthContext.Provider>
  );
}; 