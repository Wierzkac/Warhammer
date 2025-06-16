import { View, Text, ScrollView, TextInput } from 'react-native'
import React, { useState, useMemo } from 'react'
import { t } from 'react-native-tailwindcss';
import * as Icon from "react-native-feather";
import { useNavigation } from '@react-navigation/native';
import ItemCard from '../components/ItemCard'
import ScreenLayout from '../components/common/ScreenLayout';

const SearchBar = ({ value, onChangeText }) => (
  <View style={[t.flexRow, t.itemsCenter, t.bgGray100, t.roundedFull, t.pX4, t.mX4, t.mB4]}>
    <Icon.Search width="20" height="20" stroke="gray" />
    <TextInput
      style={[t.flex1, t.pL2, t.pY2]}
      placeholder="Search..."
      value={value}
      onChangeText={onChangeText}
    />
  </View>
);

export default function ItemsListScreen({ route }) {
  const navigation = useNavigation();
  
  if (!route?.params?.items) {
    return (
      <ScreenLayout showBack={true} showProfile={true}>
        <View style={[t.flex1, t.itemsCenter, t.justifyCenter]}>
          <Text style={[t.textGray500]}>No items to display</Text>
        </View>
      </ScreenLayout>
    );
  }

  const { title, items, type } = route.params;
  const [searchQuery, setSearchQuery] = useState('');

  const filteredItems = useMemo(() => {
    if (!searchQuery) return items;
    const query = searchQuery.toLowerCase();
    return items.filter(item => 
      item.name.toLowerCase().includes(query) || 
      item.description.toLowerCase().includes(query)
    );
  }, [items, searchQuery]);

  const handleItemPress = (item) => {
    navigation.navigate('ItemDetails', {
      item,
      title
    });
  };

  return (
    <ScreenLayout showProfile={true} showBack={true}>
      <View style={[t.flex1, t.p4]}>
        <SearchBar 
          value={searchQuery}
          onChangeText={setSearchQuery}
        />
        <ScrollView 
          style={[t.mt4]}
          contentContainerStyle={[t.flexGrow, t.itemsCenter, t.pB4]}
          showsVerticalScrollIndicator={false}
          scrollEnabled={true}
          zoomScale={1}
          maximumZoomScale={1}
          minimumZoomScale={1}
        >
          <View style={[t.flexRow, t.flexWrap, t.justifyCenter, t.gap4]}>
            {filteredItems.map((item, index) => (
              <View key={`${item.id}-${index}`} style={[t.mB4]}>
                <ItemCard 
                  item={item} 
                  type={type}
                  onPress={() => handleItemPress(item)}
                />
              </View>
            ))}
          </View>
        </ScrollView>
      </View>
    </ScreenLayout>
  );
} 