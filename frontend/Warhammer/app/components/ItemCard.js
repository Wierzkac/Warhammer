import React from 'react';
import { View, Text, Image, Pressable, ImageBackground } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import { useTheme } from '../context/ThemeContext';
import { getStyles } from '../themes/styles';
import { careerImages } from '../constants/careerImages';

const ItemCard = ({ item, type }) => {
  const navigation = useNavigation();
  const { isDark } = useTheme();
  const styles = getStyles(isDark);
  const isCareer = type === 'Career';

  // Convert spaces to underscores for career image lookup
  const careerImageKey = isCareer ? item.name.replace(/\s+/g, '_') : null;

  return (
    <ImageBackground
      source={require('../assets/background_light.png')}
      style={styles.card.item}
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