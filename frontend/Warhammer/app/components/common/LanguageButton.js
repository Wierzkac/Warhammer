import React from 'react';
import { Image } from 'react-native';
import { t } from 'react-native-tailwindcss';
import Button from './Button';
import { useLanguage } from '../../context/LanguageContext';

// Language button styles
const styles = {
  // Button container styles
  button: {
    base: [t.p2, t.roundedFull], // Padding and circular shape
  },
  // Flag image styles
  flag: {
    base: [t.w6, t.h6], // Fixed width and height for flag icons
  }
};

const LanguageButton = () => {
  const { language, toggleLanguage } = useLanguage();

  return (
    <Button
      variant="icon"
      onPress={toggleLanguage}
      style={styles.button.base}
    >
      <Image
        source={language === 'en' ? require('../../assets/flags/en.png') : require('../../assets/flags/pl.png')}
        style={styles.flag.base}
      />
    </Button>
  );
};

export default LanguageButton; 