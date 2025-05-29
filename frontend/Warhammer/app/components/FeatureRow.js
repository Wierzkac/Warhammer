import { View, Text, TouchableOpacity, ScrollView } from 'react-native'
import React from 'react'
import PropTypes from 'prop-types'
import { t } from 'react-native-tailwindcss';
import { themeColors } from '../themes/themes';
import ItemCard from './ItemCard'
import { useNavigation } from '@react-navigation/native';

const SectionHeader = ({ title, description, onSeeAll }) => (
  <View style={[t.flexRow, t.justifyBetween, t.itemsCenter, t.pX4]}>
    <View>
      <Text style={[t.fontBold, t.textLg]}>{title}</Text>
      <Text style={[t.textGray500, t.textXs]}>{description}</Text>
    </View>
    <TouchableOpacity onPress={onSeeAll}>
      <Text style={[t.fontSemibold, {color: themeColors.text}]}>See all</Text>
    </TouchableOpacity>
  </View>
);

SectionHeader.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  onSeeAll: PropTypes.func
};

export default function FeatureRow({ title, description, items }) {
  const navigation = useNavigation();

  const handleSeeAll = () => {
    // Ensure we have valid items before navigating
    if (!items || !Array.isArray(items) || items.length === 0) {
      console.warn('No items to display');
      return;
    }

    navigation.navigate('ItemsList', {
      title,
      items: items.map(item => ({
        id: item.id,
        name: item.name,
        description: item.description,
        image: item.image
      }))
    });
  };

  // Determine the type based on the title
  const getItemType = () => {
    if (title.toLowerCase().includes('career')) return 'Career';
    if (title.toLowerCase().includes('talent')) return 'Talent';
    if (title.toLowerCase().includes('skill')) return 'Skill';
    return 'Item';
  };

  return (
    <View>
      <SectionHeader 
        title={title} 
        description={description} 
        onSeeAll={handleSeeAll}
      />
      <ScrollView
        horizontal
        showsHorizontalScrollIndicator={false}
        contentContainerStyle={{
          paddingHorizontal: 15
        }}
        style={[t.overflowVisible, t.pY5]}
      >
        {items.map((item, index) => (
          <ItemCard
            key={`${item.id}-${index}`}
            item={item}
            type={getItemType()}
          />
        ))}
      </ScrollView>
    </View>
  )
}

FeatureRow.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired,
  items: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      description: PropTypes.string,
      image: PropTypes.any
    })
  ).isRequired
};