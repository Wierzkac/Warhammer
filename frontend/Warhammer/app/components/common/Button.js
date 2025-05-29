import React from 'react';
import { TouchableOpacity, Text, ActivityIndicator } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { layout } from '../../theme/styles';

const Button = ({ 
  onPress, 
  title, 
  variant = 'primary', 
  disabled = false,
  loading = false,
  style = [],
  textStyle = []
}) => {
  const getButtonStyle = () => {
    const baseStyle = [layout.button[variant]];
    if (disabled) {
      baseStyle.push(t.opacity50);
    }
    return [...baseStyle, ...style];
  };

  return (
    <TouchableOpacity
      onPress={onPress}
      disabled={disabled || loading}
      style={getButtonStyle()}
    >
      {loading ? (
        <ActivityIndicator color="white" size="small" />
      ) : (
        <Text style={[t.textWhite, t.fontBold, t.textCenter, ...textStyle]}>
          {title}
        </Text>
      )}
    </TouchableOpacity>
  );
};

export default Button; 