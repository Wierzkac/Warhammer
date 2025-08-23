import React from 'react';
import { View, Text } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useTheme } from '../../context/ThemeContext';
import Button from './Button';

const ThemeToggle = () => {
  const { isDark, toggleTheme } = useTheme();

  return (
    <Button
      onPress={toggleTheme}
      variant="icon"
      style={[t.flexRow, t.itemsCenter, t.pX3, t.pY2, t.roundedFull]}
    >
      <Text style={[t.textLg, t.mR2]}>
        {isDark ? '☀️' : '🌙'}
      </Text>
      <Text style={[t.textSm, t.fontMedium, t.textGray800]}>
        {isDark ? 'Light' : 'Dark'}
      </Text>
    </Button>
  );
};

export default ThemeToggle; 