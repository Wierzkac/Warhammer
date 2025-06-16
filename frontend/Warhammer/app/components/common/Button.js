import React from 'react';
import { TouchableOpacity, Text, ActivityIndicator } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { layout } from '../../../styles';

// Button styles organized by purpose
const styles = {
  // Base button styles
  button: {
    base: [t.p3, t.roundedLg, t.itemsCenter, t.justifyCenter], // Padding, rounded corners, centered content
    disabled: [t.opacity50], // Reduced opacity when disabled
  },
  // Text styles
  text: {
    base: [t.textWhite, t.fontBold, t.textCenter], // White text, bold, centered
  },
  // Variant-specific styles
  variants: {
    primary: [t.bgOrange500], // Orange background for primary buttons
    secondary: [t.bgGray500], // Gray background for secondary buttons
    icon: [t.bgTransparent], // Transparent background for icon buttons
  }
};

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
  const getButtonStyle = () => {
    const baseStyle = [...styles.button.base, ...styles.variants[variant]];
    if (disabled) {
      baseStyle.push(...styles.button.disabled);
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
      ) : children ? (
        children
      ) : (
        <Text style={[...styles.text.base, ...textStyle]}>
          {title}
        </Text>
      )}
    </TouchableOpacity>
  );
};

export default Button; 