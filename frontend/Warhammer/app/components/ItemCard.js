import { View, Text, TouchableOpacity, Image } from 'react-native';
import React from 'react';
import PropTypes from 'prop-types';
import { t } from 'react-native-tailwindcss';
import { themeColors } from '../themes/themes';
import { useNavigation } from '@react-navigation/native';

const CardImage = ({ source }) => (
  <Image 
    style={[t.h50, t.w25, t.roundedTLg]} 
    source={source}
    resizeMode="cover"
  />
);

CardImage.propTypes = {
  source: PropTypes.any.isRequired
};

const CardContent = ({ name, description }) => (
  <View style={[t.pX3, t.pB4, t.flex1, t.itemsCenter]}>
    <Text style={[t.textLg, t.fontBold, t.pT2]}>{name}</Text>
    {description && (
      <Text style={[t.textSm, t.textGray600, t.mT1]} numberOfLines={2}>
        {description}
      </Text>
    )}
  </View>
);

CardContent.propTypes = {
  name: PropTypes.string.isRequired,
  description: PropTypes.string
};

export default function ItemCard({ item, type }) {
  const navigation = useNavigation();

  const handlePress = () => {
    navigation.navigate('ItemDetails', {
      item,
      title: `${type} Details`
    });
  };

  return (
    <TouchableOpacity 
      onPress={handlePress}
      style={[
        t.mR6, 
        t.bgWhite, 
        t.roundedL, 
        t.shadowLg, 
        {shadowColor: themeColors.bgColor(0.2), shadowRadius: 7}
      ]}
    >
      {item.image && <CardImage source={item.image} />}
      <CardContent name={item.name} description={item.description} />
    </TouchableOpacity>
  );
}

ItemCard.propTypes = {
  item: PropTypes.shape({
    id: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    description: PropTypes.string,
    image: PropTypes.any
  }).isRequired,
  type: PropTypes.oneOf(['Career', 'Talent', 'Skill']).isRequired
}; 