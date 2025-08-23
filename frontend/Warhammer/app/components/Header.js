import React from 'react';
import { View, Text, Pressable, Image } from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { useTheme } from '../context/ThemeContext';
import LanguageButton from './common/LanguageButton';
import ThemeToggle from './common/ThemeToggle';
import { getStyles } from '../themes/styles';

const Header = ({ title, showBack = true, showProfile = true, showThemeToggle = true }) => {
  const navigation = useNavigation();
  const { isDark } = useTheme();
  const styles = getStyles(isDark);

  return (
    <View style={styles.header.container}>
      <View style={styles.header.leftSection}>
        {showBack && (
          <Pressable
            onPress={() => navigation.goBack()}
            style={styles.header.backButton}
          >
            <Text style={styles.header.backText}>
              
            </Text>
          </Pressable>
        )}
        <View style={styles.header.titleContainer}>
          <Text style={styles.header.titleText}>{title}</Text>
        </View>
      </View>
      <View style={styles.header.rightSection}>
        {showThemeToggle && <ThemeToggle />}
        <LanguageButton />
        {showProfile && (
          <Pressable
            onPress={() => navigation.navigate('Profile')}
            style={styles.header.profileButton}
          >
            <Image
              source={require('../assets/favicon.png')}
              style={styles.header.profileImage}
            />
          </Pressable>
        )}
      </View>
    </View>
  );
};

export default Header; 