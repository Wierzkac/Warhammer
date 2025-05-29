import { View, Text, ScrollView, TextInput, Image, TouchableOpacity } from 'react-native'
import React, { useState, useMemo } from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import { t } from 'react-native-tailwindcss';
import Header from '../components/Header';
import * as Icon from "react-native-feather";
import { useNavigation } from '@react-navigation/native';

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

const ItemCard = ({ item, onPress }) => (
  <TouchableOpacity 
    onPress={onPress}
    style={[t.bgWhite, t.roundedLg, t.p4, t.mX4, t.mB4, t.shadowMd]}
  >
    <View style={[t.flexRow, t.itemsCenter]}>
      <View style={[t.w16, t.h16, t.roundedLg, t.overflowHidden, t.mR4]}>
        <Image 
          source={item.image}
          style={[t.wFull, t.hFull]}
          resizeMode="cover"
        />
      </View>
      <View style={[t.flex1]}>
        <Text style={[t.textLg, t.fontBold]}>{item.name}</Text>
        <Text style={[t.textGray500, t.textSm]}>{item.description}</Text>
      </View>
      <Icon.ChevronRight width="20" height="20" stroke="gray" />
    </View>
  </TouchableOpacity>
);

export default function ItemsListScreen({ route }) {
  const navigation = useNavigation();
  
  // Add error handling for missing route params
  if (!route?.params?.items) {
    return (
      <SafeAreaView style={[t.flex1, t.bgGray50]}>
        <Header showBack={true} showProfile={true} />
        <View style={[t.flex1, t.itemsCenter, t.justifyCenter]}>
          <Text style={[t.textGray500]}>No items to display</Text>
        </View>
      </SafeAreaView>
    );
  }

  const { title, items } = route.params;
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
    <SafeAreaView style={[t.flex1, t.bgGray50]}>
      <Header showBack={true} showProfile={true} />
      
      <SearchBar 
        value={searchQuery}
        onChangeText={setSearchQuery}
      />

      <ScrollView 
        showsVerticalScrollIndicator={false}
        contentContainerStyle={[t.pB4]}
      >
        {filteredItems.length === 0 ? (
          <View style={[t.flex1, t.itemsCenter, t.justifyCenter, t.pT8]}>
            <Text style={[t.textGray500]}>No items found</Text>
          </View>
        ) : (
          filteredItems.map((item, index) => (
            <ItemCard 
              key={`${item.id}-${index}`} 
              item={item}
              onPress={() => handleItemPress(item)}
            />
          ))
        )}
      </ScrollView>
    </SafeAreaView>
  );
} 