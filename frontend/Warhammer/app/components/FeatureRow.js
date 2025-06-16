import { View, Text, Pressable, ScrollView, StyleSheet } from 'react-native'
import React from 'react'
import PropTypes from 'prop-types'
import { themeColors } from '../themes/themes';
import ItemCard from './ItemCard'
import { useNavigation } from '@react-navigation/native';

const styles = StyleSheet.create({
  sectionHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingHorizontal: 16
  },
  title: {
    fontWeight: 'bold',
    fontSize: 18
  },
  description: {
    color: '#6B7280',
    fontSize: 12
  },
  seeAllText: {
    fontWeight: '600',
    color: themeColors.text
  },
  scrollView: {
    overflow: 'visible',
    paddingVertical: 20
  },
  scrollViewContent: {
    paddingHorizontal: 15
  }
});

const SectionHeader = ({ title, description, onSeeAll }) => (
  <View style={styles.sectionHeader}>
    <View>
      <Text style={styles.title}>{title}</Text>
      <Text style={styles.description}>{description}</Text>
    </View>
    <Pressable onPress={onSeeAll}>
      <Text style={styles.seeAllText}>See all</Text>
    </Pressable>
  </View>
);

SectionHeader.propTypes = {
  title: PropTypes.string.isRequired,
  onSeeAll: PropTypes.func
};

export default function FeatureRow({ title, items, type }) {
  const navigation = useNavigation();

  console.log('FeatureRow props:', { title, items, type });

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
        image: item.image
      })),
      type
    });
  };

  // Use the provided type or determine it based on the title
  const getItemType = () => {
    if (type) return type;
    if (title.toLowerCase().includes('career')) return 'Career';
    if (title.toLowerCase().includes('talent')) return 'Talent';
    if (title.toLowerCase().includes('skill')) return 'Skill';
    return 'Item';
  };

  const itemType = getItemType();
  console.log('ItemType:', itemType);

  if (!items || !Array.isArray(items)) {
    console.warn('Invalid items prop:', items);
    return null;
  }

  return (
    <View>
      <SectionHeader 
        title={title} 
        onSeeAll={handleSeeAll}
      />
      <ScrollView
        horizontal
        showsHorizontalScrollIndicator={false}
        contentContainerStyle={styles.scrollViewContent}
        style={styles.scrollView}
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
  )
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