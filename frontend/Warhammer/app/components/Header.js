import React from 'react';
import { View, Text, Pressable, Image } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import { useTheme } from '../context/ThemeContext';
import LanguageButton from './common/LanguageButton';

// Header styles organized by section
const styles = {
  // Main container styles
  container: {
    base: [t.flexRow, t.itemsCenter, t.justifyBetween, t.pX4, t.pY2], // Flex layout with padding
    dark: [t.bgGray900], // Dark theme background
    light: [t.bgOrange200], // Light theme background
  },
  // Left section styles (back button and title)
  leftSection: {
    base: [t.flexRow, t.itemsCenter], // Flex layout for back button and title
    backButton: [t.mR4], // Margin for back button
    title: [t.flex1], // Take remaining space
  },
  // Right section styles (language and profile buttons)
  rightSection: {
    base: [t.flexRow, t.itemsCenter], // Flex layout for buttons
    profileButton: [t.mL4], // Margin for profile button
  },
  // Text styles
  text: {
    back: [t.text2xl, t.textGray800], // Back arrow style
    title: [t.textXl, t.fontBold, t.textGray800], // Title text style
  },
  // Profile image styles
  profile: {
    base: [t.w8, t.h8, t.roundedFull], // Circular profile image
  }
};

const Header = ({ title, showBack = true, showProfile = true }) => {
  const navigation = useNavigation();
  const { theme } = useTheme();

  const headerColor = theme === 'dark' ? styles.container.dark : styles.container.light;

  return (
    <View style={[...styles.container.base, headerColor]}>
      <View style={styles.leftSection.base}>
        {showBack && (
          <Pressable
            onPress={() => navigation.goBack()}
            style={styles.leftSection.backButton}
          >
            <Text style={styles.text.back}>←</Text>
          </Pressable>
        )}
        <View style={styles.leftSection.title}>
          <Text style={styles.text.title}>{title}</Text>
        </View>
      </View>
      <View style={styles.rightSection.base}>
        <LanguageButton />
        {showProfile && (
          <Pressable
            onPress={() => navigation.navigate('Profile')}
            style={styles.rightSection.profileButton}
          >
            <Image
              source={require('../assets/favicon.png')}
              style={styles.profile.base}
            />
          </Pressable>
        )}
      </View>
    </View>
  );
};

export default Header; 