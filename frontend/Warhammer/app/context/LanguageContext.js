import React, { createContext, useState, useContext, useCallback } from 'react';
import { clearCache } from '../services/api/client';

const LanguageContext = createContext();

export const LanguageProvider = ({ children }) => {
  const [language, setLanguage] = useState('en');
  const [refreshTrigger, setRefreshTrigger] = useState(0);

  const toggleLanguage = useCallback(() => {
    console.log('Toggling language, current:', language);
    const newLanguage = language === 'en' ? 'pl' : 'en';
    setLanguage(newLanguage);
    // Clear API cache when language changes
    clearCache();
    setRefreshTrigger(prev => {
      console.log('Incrementing refresh trigger from:', prev);
      return prev + 1;
    });
  }, [language]);

  console.log('LanguageContext state:', { language, refreshTrigger });

  return (
    <LanguageContext.Provider value={{ language, toggleLanguage, refreshTrigger }}>
      {children}
    </LanguageContext.Provider>
  );
};

export const useLanguage = () => {
  const context = useContext(LanguageContext);
  if (!context) {
    throw new Error('useLanguage must be used within a LanguageProvider');
  }
  return context;
}; 