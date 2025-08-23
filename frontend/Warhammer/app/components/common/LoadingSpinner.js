import React from 'react';
import { ActivityIndicator } from 'react-native';
import { useTheme } from '../../context/ThemeContext';
import { getStyles } from '../../themes/styles';

const LoadingSpinner = ({ size = 'small', color, variant = 'primary' }) => {
  const { isDark } = useTheme();
  const styles = getStyles(isDark);
  // Use color prop if provided, otherwise use centralized spinner color
  const spinnerColor = color || styles.button.spinner?.[variant]?.color || styles.button.text[0]?.color || '#fff';
  return <ActivityIndicator size={size} color={spinnerColor} />;
};

export default LoadingSpinner; 