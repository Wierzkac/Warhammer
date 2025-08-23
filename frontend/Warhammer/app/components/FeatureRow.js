import { View, Text, Pressable, ScrollView } from 'react-native';
import React from 'react';
import PropTypes from 'prop-types';
import ItemCard from './ItemCard';
import { useNavigation } from '@react-navigation/native';
import { useTheme } from '../context/ThemeContext';
import { getStyles } from '../themes/styles';

const SectionHeader = ({ title, description, onSeeAll, styles }) => (
  <View style={styles.feature.sectionHeader}>
    <View>
      <Text style={styles.feature.title}>{title}</Text>
      {description && <Text style={styles.feature.description}>{description}</Text>}
    </View>
    <Pressable onPress={onSeeAll}>
      <Text style={styles.feature.seeAllText}>See all</Text>
    </Pressable>
  </View>
);

SectionHeader.propTypes = {
  title: PropTypes.string.isRequired,
  onSeeAll: PropTypes.func,
  description: PropTypes.string,
  styles: PropTypes.object.isRequired,
};

export default function FeatureRow({ title, items, type, description }) {
  const navigation = useNavigation();
  const { isDark } = useTheme();
  const styles = getStyles(isDark);

  const handleSeeAll = () => {
    if (!items || !Array.isArray(items) || items.length === 0) {
      console.warn('No items to display');
      return;
    }
    navigation.navigate('ItemsList', {
      title,
      items: items.map(item => ({
        id: item.id,
        name: item.name,
        image: item.image
      })),
      type
    });
  };

  const getItemType = () => {
    if (type) return type;
    if (title.toLowerCase().includes('career')) return 'Career';
    if (title.toLowerCase().includes('talent')) return 'Talent';
    if (title.toLowerCase().includes('skill')) return 'Skill';
    return 'Item';
  };

  const itemType = getItemType();

  if (!items || !Array.isArray(items)) {
    console.warn('Invalid items prop:', items);
    return null;
  }

  return (
    <View>
      <SectionHeader 
        title={title} 
        description={description}
        onSeeAll={handleSeeAll}
        styles={styles}
      />
      <ScrollView
        horizontal
        showsHorizontalScrollIndicator={false}
        contentContainerStyle={styles.feature.scrollViewContent}
        style={styles.feature.scrollView}
      >
        {items.map((item, index) => {
          return (
            <ItemCard
              key={`${item.id}-${index}`}
              item={item}
              type={itemType}
            />
          );
        })}
      </ScrollView>
    </View>
  );
}

FeatureRow.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.string,
  items: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      description: PropTypes.string,
      image: PropTypes.any
    })
  ).isRequired,
  type: PropTypes.string
};