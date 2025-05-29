import React, { createContext, useState, useContext } from 'react';

const ThemeContext = createContext();

export const themeColors = {
  orange: '#f97316', // Current theme
  blue: '#3b82f6',
  green: '#22c55e',
  purple: '#a855f7',
  pink: '#ec4899',
  red: '#ef4444',
  teal: '#14b8a6',
  indigo: '#6366f1',
  yellow: '#eab308',
  gray: '#6b7280'
};

export const ThemeProvider = ({ children }) => {
  const [headerColor, setHeaderColor] = useState(themeColors.orange);

  return (
    <ThemeContext.Provider value={{ headerColor, setHeaderColor }}>
      {children}
    </ThemeContext.Provider>
  );
};

export const useTheme = () => {
  const context = useContext(ThemeContext);
  if (!context) {
    throw new Error('useTheme must be used within a ThemeProvider');
  }
  return context;
}; 