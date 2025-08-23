import React from 'react';
import { TouchableOpacity, Text } from 'react-native';
import { useTheme } from '../../context/ThemeContext';
import { getStyles } from '../../themes/styles';
import LoadingSpinner from './LoadingSpinner';

const Button = ({ 
  onPress, 
  title, 
  variant = 'primary', 
  disabled = false,
  loading = false,
  style = [],
  textStyle = [],
  children
}) => {
  const { isDark } = useTheme();
  const styles = getStyles(isDark);

  const getButtonStyle = () => {
    let buttonStyle = styles.button[variant] || styles.button.primary;
    if (disabled) {
      buttonStyle = [
        ...buttonStyle,
        styles.button.disabled
      ];
    }
    return [buttonStyle, ...style];
  };

  return (
    <TouchableOpacity
      onPress={onPress}
      disabled={disabled || loading}
      style={getButtonStyle()}
    >
      {loading ? (
        <LoadingSpinner variant={variant} size="small" />
      ) : children ? (
        children
      ) : (
        <Text style={[styles.button.text, ...textStyle]}>
          {title}
        </Text>
      )}
    </TouchableOpacity>
  );
};

export default Button; 