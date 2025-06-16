import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { AuthProvider } from './app/context/AuthContext';
import { LanguageProvider } from './app/context/LanguageContext';
import { ThemeProvider } from './app/context/ThemeContext';
import Navigation from './navigation';
import ErrorBoundary from './app/components/common/ErrorBoundary';
import { LogBox } from 'react-native';

// Ignore specific warnings
LogBox.ignoreLogs([
  'ViewPropTypes will be removed',
  'ColorPropType will be removed',
]);

const App = () => {
  return (
    <ErrorBoundary>
      <ThemeProvider>
        <LanguageProvider>
          <AuthProvider>
            <NavigationContainer>
              <Navigation />
            </NavigationContainer>
          </AuthProvider>
        </LanguageProvider>
      </ThemeProvider>
    </ErrorBoundary>
  );
};

export default App;