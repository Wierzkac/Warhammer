import { View, Text, TouchableOpacity, ScrollView } from 'react-native'
import React from 'react'
import { t } from 'react-native-tailwindcss';
import { themeColors } from '../themes';
import CareerCard from './CareerCard'

export default function FeatureRow({title, description, items}) {
  return (
    <View>
      <View style={[t.flexRow, t.justifyBetween, t.itemsCenter, t.pX4]}>
        <View>
          <Text style={[t.fontBold, t.textLg]}>{title}</Text>
          <Text style={[t.textGray500, t.textXs]}>{description}</Text>
        </View>
        <TouchableOpacity>
          <Text style={[t.fontSemibold, {color: themeColors.text}]}>See all</Text>
        </TouchableOpacity>
      </View>
      <ScrollView
        horizontal
        showsHorizontalScrollIndicator={false}
        contentContainerStyle={{
          paddingHorizontal: 15
        }}
        style={[t.overflowVisible, t.pY5]}
      >
        {
          items.map((career, index) => {
            return (
              <CareerCard
                item={career}
                key={index}
              />
            )
          })
        }
      </ScrollView>
    </View>
  )
}