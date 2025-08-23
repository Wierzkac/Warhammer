import { t } from 'react-native-tailwindcss';
import { lightThemeColors, darkThemeColors } from './themeColors';

// Function to get styles with the correct theme colors
export const getStyles = (isDark = false) => {
  const colors = isDark ? darkThemeColors : lightThemeColors;
  
  return {
    // Container styles
    container: {
      base: [t.flex1],
      centered: [t.flex1, t.itemsCenter, t.justifyCenter],
      padded: [t.flex1, t.p4],
      screen: [t.flex1, t.p4, t.justifyCenter],
    },
    
    // Card styles
    card: {
      base: [
        t.roundedLg,
        t.overflowHidden,
        t.shadowMd,
        { backgroundColor: colors.card },
      ],
      compact: [
        t.p3,
        t.roundedMd,
        { backgroundColor: colors.surface },
      ],
      item: [
        t.mR6,
        t.mB4,
        t.w40,
        t.h60,
        t.roundedLg,
        t.overflowHidden,
        t.shadowMd,
        { backgroundColor: colors.card },
      ],
    },
    
    // Text styles
    text: {
      title: [
        t.textXl,
        t.fontBold,
        { color: colors.text },
      ],
      subtitle: [
        t.textLg,
        t.fontSemibold,
        { color: colors.text },
      ],
      body: [
        t.textBase,
        { color: colors.text },
      ],
      caption: [
        t.textSm,
        { color: colors.textSecondary },
      ],
      muted: [
        t.textSm,
        { color: colors.textMuted },
      ],
      primary: [
        t.fontMedium,
        { color: colors.primary },
      ],
      error: [
        t.textSm,
        t.mT1,
        { color: colors.error },
      ],
      success: [
        { color: colors.success },
      ],
      link: [
        { color: colors.link },
      ],
    },
    
    // Button styles
    button: {
      primary: [
        t.pX6,
        t.pY3,
        t.roundedFull,
        t.itemsCenter,
        t.justifyCenter,
        { backgroundColor: colors.primary },
      ],
      secondary: [
        t.pX6,
        t.pY3,
        t.roundedFull,
        t.itemsCenter,
        t.justifyCenter,
        t.border,
        { backgroundColor: colors.surface },
        { borderColor: colors.border },
      ],
      danger: [
        t.pX6,
        t.pY3,
        t.roundedFull,
        t.itemsCenter,
        t.justifyCenter,
        { backgroundColor: colors.error },
      ],
      icon: [
        t.bgTransparent,
        t.itemsCenter,
        t.justifyCenter,
        t.p2,
        t.roundedFull,
      ],
      disabled: [
        t.opacity50,
      ],
      text: [
        t.textWhite,
        t.fontBold,
        t.textCenter,
      ],
      textSecondary: [
        { color: colors.text },
        t.fontBold,
      ],
      spinner: {
        primary: { color: colors.textOnPrimary },
        secondary: { color: colors.textOnSecondary },
        danger: { color: colors.textOnDanger },
        icon: { color: colors.primary },
      },
    },
    
    // Input styles
    input: {
      base: [
        t.p3,
        t.roundedLg,
        t.border,
        { 
          backgroundColor: colors.surface,
          borderColor: colors.border,
          color: colors.text,
        },
      ],
      error: [
        { borderColor: colors.error },
      ],
      label: [
        { color: colors.text },
        t.mB1,
        t.fontMedium,
      ],
    },
    
    // Header styles
    header: {
      container: [
        t.flexRow,
        t.itemsCenter,
        t.justifyBetween,
        t.pX4,
        t.pY3,
        { backgroundColor: colors.surface, borderBottomWidth: 1, borderBottomColor: colors.border },
      ],
      leftSection: [
        t.flexRow,
        t.itemsCenter,
        t.flex1,
      ],
      backButton: [
        t.mR4,
        t.p1,
      ],
      titleContainer: [
        t.flex1,
      ],
      titleText: [
        t.textLg,
        t.fontBold,
        { color: colors.text },
      ],
      backText: [
        t.text2xl,
        { color: colors.text },
      ],
      rightSection: [
        t.flexRow,
        t.itemsCenter,
      ],
      profileButton: [
        t.mL3,
      ],
      profileImage: [
        t.w8,
        t.h8,
        t.roundedFull,
      ],
    },
    
    // List styles
    list: {
      item: [
        t.pY3,
        t.borderB,
        { borderBottomColor: colors.borderLight },
      ],
      separator: [
        t.hPx,
        { backgroundColor: colors.borderLight },
      ],
    },
    
    // Spacing utilities
    spacing: {
      section: [t.mB6],
      item: [t.mB4],
      small: [t.mB2],
    },

    // FeatureRow styles
    feature: {
      sectionHeader: [
        t.flexRow,
        t.justifyBetween,
        t.itemsCenter,
        t.pX4,
      ],
      title: [
        t.fontBold,
        t.textBase,
        { color: colors.text },
      ],
      description: [
        t.textXs,
        { color: colors.textSecondary },
      ],
      seeAllText: [
        t.fontSemibold,
        { color: colors.link },
      ],
      scrollView: [
        { overflow: 'visible' },
        t.pY5,
      ],
      scrollViewContent: [
        t.pX4,
      ],
    },
  };
};

// Common style combinations (these don't need theme colors)
export const commonStyles = {
  screenContainer: [t.flex1, t.p4],
  centeredContent: [t.flex1, t.itemsCenter, t.justifyCenter],
  cardContainer: [t.mB4, t.roundedLg, t.overflowHidden],
  textCenter: [t.textCenter],
  flexRow: [t.flexRow, t.itemsCenter],
  flexRowBetween: [t.flexRow, t.itemsCenter, t.justifyBetween],
}; 