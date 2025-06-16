import React from 'react';
import { View, Text, Image, Pressable, ImageBackground } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import { careerImages } from '../constants/careerImages';

// Item card styles organized by section
const styles = {
  // Card container styles
  card: {
    base: [
      t.mR6, // Right margin
      t.mB4, // Bottom margin
      t.bgWhite, // White background
      t.roundedLg, // Large border radius
      t.overflowHidden, // Hide overflow content
      t.shadowMd, // Medium shadow
    ],
  },
  // Image styles
  image: {
    base: [
      t.w40, // Fixed width
      t.h60, // Fixed height
    ],
  },
  // Content container styles
  content: {
    base: [t.p4], // Padding all around
  },
  // Text styles
  text: {
    title: [
      t.textLg, // Large text size
      t.fontBold, // Bold font weight
      t.textGray800, // Dark gray text color
    ],
    description: [
      t.textSm, // Small text size
      t.textGray600, // Medium gray text color
    ],
  },
};

const ItemCard = ({ item, type }) => {
  const navigation = useNavigation();
  const isCareer = type === 'Career';

  // Convert spaces to underscores for career image lookup
  const careerImageKey = isCareer ? item.name.replace(/\s+/g, '_') : null;

  return (
    <ImageBackground
      source={require('../assets/background_light.png')}
      style={styles.card.base}
    >
      <Pressable
        onPress={() => navigation.navigate('ItemDetails', { item })}
        style={[
          t.flex1,
          !isCareer && t.p4 // Add padding when not a career
        ]}
      >
        {isCareer && careerImages[careerImageKey] && (
          <Image
            source={careerImages[careerImageKey]}
            style={styles.image.base}
            resizeMode="contain"
          />
        )}
        <View style={[
          styles.content.base,
          !isCareer && t.p0 // Remove padding when not a career
        ]}>
          <Text style={styles.text.title}>{item.name}</Text>
        </View>
      </Pressable>
    </ImageBackground>
  );
};

export default ItemCard; 