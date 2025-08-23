import { useMemo } from 'react';
import { StyleSheet } from 'react-native';
import { useTheme } from '../context/ThemeContext';

export const useThemeStyles = () => {
  const { currentTheme, isDark } = useTheme();

  const themeStyles = useMemo(() => ({
    // Container styles
    container: {
      flex: 1,
      backgroundColor: currentTheme.background,
    },
    safeContainer: {
      flex: 1,
      backgroundColor: currentTheme.background,
      paddingTop: 50, // Adjust based on your status bar height
    },
    
    // Card styles
    card: {
      backgroundColor: currentTheme.surface,
      borderRadius: 12,
      padding: 16,
      marginVertical: 8,
      marginHorizontal: 16,
      shadowColor: isDark ? '#000' : '#000',
      shadowOffset: { width: 0, height: 2 },
      shadowOpacity: isDark ? 0.3 : 0.1,
      shadowRadius: 8,
      elevation: 4,
    },
    cardCompact: {
      backgroundColor: currentTheme.surface,
      borderRadius: 8,
      padding: 12,
      marginVertical: 4,
      marginHorizontal: 16,
    },
    
    // Text styles
    text: {
      color: currentTheme.text,
    },
    textSecondary: {
      color: currentTheme.textSecondary,
    },
    textPrimary: {
      color: currentTheme.primary,
    },
    textSuccess: {
      color: currentTheme.success,
    },
    textError: {
      color: currentTheme.error,
    },
    textWarning: {
      color: currentTheme.warning,
    },
    textInfo: {
      color: currentTheme.info,
    },
    
    // Typography styles
    title: {
      fontSize: 24,
      fontWeight: 'bold',
      color: currentTheme.text,
    },
    subtitle: {
      fontSize: 18,
      fontWeight: '600',
      color: currentTheme.text,
    },
    body: {
      fontSize: 16,
      color: currentTheme.text,
    },
    caption: {
      fontSize: 14,
      color: currentTheme.textSecondary,
    },
    small: {
      fontSize: 12,
      color: currentTheme.textSecondary,
    },
    
    // Border styles
    border: {
      borderColor: currentTheme.border,
      borderWidth: 1,
    },
    borderTop: {
      borderTopColor: currentTheme.border,
      borderTopWidth: 1,
    },
    borderBottom: {
      borderBottomColor: currentTheme.border,
      borderBottomWidth: 1,
    },
    
    // Button styles
    button: {
      backgroundColor: currentTheme.primary,
      borderRadius: 8,
      paddingVertical: 12,
      paddingHorizontal: 24,
      alignItems: 'center',
      justifyContent: 'center',
    },
    buttonText: {
      color: currentTheme.background,
      fontSize: 16,
      fontWeight: '600',
    },
    buttonSecondary: {
      backgroundColor: currentTheme.surface,
      borderRadius: 8,
      paddingVertical: 12,
      paddingHorizontal: 24,
      alignItems: 'center',
      justifyContent: 'center',
      borderWidth: 1,
      borderColor: currentTheme.border,
    },
    buttonSecondaryText: {
      color: currentTheme.text,
      fontSize: 16,
      fontWeight: '600',
    },
    
    // Input styles
    input: {
      backgroundColor: currentTheme.surface,
      borderColor: currentTheme.border,
      borderWidth: 1,
      borderRadius: 8,
      paddingHorizontal: 12,
      paddingVertical: 12,
      color: currentTheme.text,
      fontSize: 16,
    },
    inputFocused: {
      borderColor: currentTheme.primary,
    },
    
    // Divider
    divider: {
      height: 1,
      backgroundColor: currentTheme.border,
      marginVertical: 16,
    },
    
    // Spacing utilities
    padding: {
      padding: 16,
    },
    paddingHorizontal: {
      paddingHorizontal: 16,
    },
    paddingVertical: {
      paddingVertical: 16,
    },
    margin: {
      margin: 16,
    },
    marginHorizontal: {
      marginHorizontal: 16,
    },
    marginVertical: {
      marginVertical: 16,
    },
  }), [currentTheme, isDark]);

  return themeStyles;
};

// Helper function to create themed StyleSheet
export const createThemedStyleSheet = (styleFactory) => {
  return (isDark, theme) => StyleSheet.create(styleFactory(isDark, theme));
}; 