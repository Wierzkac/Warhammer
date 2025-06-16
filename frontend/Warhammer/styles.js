import { t } from 'react-native-tailwindcss';

export const colors = {
  primary: '#3B82F6', // blue-500
  secondary: '#6B7280', // gray-500
  success: '#10B981', // green-500
  danger: '#EF4444', // red-500
  warning: '#F59E0B', // amber-500
  info: '#3B82F6', // blue-500
  light: '#F3F4F6', // gray-100
  dark: '#1F2937', // gray-800
  white: '#FFFFFF',
  black: '#000000',
};

export const spacing = {
  xs: 4,
  sm: 8,
  md: 16,
  lg: 24,
  xl: 32,
  xxl: 48,
};

export const typography = {
  h1: [t.text4xl, t.fontBold],
  h2: [t.text3xl, t.fontBold],
  h3: [t.text2xl, t.fontBold],
  h4: [t.textXl, t.fontBold],
  body: [t.textBase],
  small: [t.textSm],
  caption: [t.textXs],
};

export const shadows = {
  sm: [t.shadowSm],
  md: [t.shadowMd],
  lg: [t.shadowLg],
  xl: [t.shadowXl],
};

export const borderRadius = {
  none: 0,
  sm: 4,
  md: 8,
  lg: 12,
  xl: 16,
  full: 9999,
};

export const layout = {
  container: [t.p4],
  row: [t.flexRow, t.itemsCenter],
  center: [t.itemsCenter, t.justifyCenter],
  card: [t.bgWhite, t.roundedLg, t.p4, t.shadowMd],
  button: {
    primary: [t.bgBlue500, t.pX4, t.pY2, t.roundedLg],
    secondary: [t.bgGray500, t.pX4, t.pY2, t.roundedLg],
    danger: [t.bgRed500, t.pX4, t.pY2, t.roundedLg],
    icon: [t.bgTransparent, t.itemsCenter, t.justifyCenter],
  },
}; 