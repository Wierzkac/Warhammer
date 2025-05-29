import { View, Text, Image, ScrollView } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import { t } from 'react-native-tailwindcss';
import Header from '../components/Header';

export default function ItemDetailsScreen({ route }) {
  const { item } = route.params;

  return (
    <SafeAreaView style={[t.flex1, t.bgGray50]}>
      <Header showBack={true} showProfile={true} />
      
      <ScrollView 
        showsVerticalScrollIndicator={false}
        contentContainerStyle={[t.pB4]}
      >
        <View style={[t.p4]}>
          <Image 
            source={item.image}
            style={[t.wFull, t.h64, t.roundedLg, t.mB4]}
            resizeMode="cover"
          />
          
          <Text style={[t.text2xl, t.fontBold, t.mB2]}>{item.name}</Text>
          <Text style={[t.textGray600, t.mB4]}>{item.description}</Text>

          {/* Add more details here based on the item type */}
          <View style={[t.bgWhite, t.roundedLg, t.p4, t.shadowMd]}>
            <Text style={[t.textLg, t.fontBold, t.mB2]}>Details</Text>
            {/* Add specific details based on item type */}
            <View style={[t.flexRow, t.justifyBetween, t.mB2]}>
              <Text style={[t.textGray600]}>ID</Text>
              <Text style={[t.fontSemibold]}>{item.id}</Text>
            </View>
            {/* Add more details as needed */}
          </View>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
} 