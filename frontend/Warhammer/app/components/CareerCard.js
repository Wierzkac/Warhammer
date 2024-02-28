import { View, Text, TouchableWithoutFeedback, Image } from 'react-native'
import React from 'react'
import { t, tw } from 'react-native-tailwindcss';
import { themeColors } from '../themes';

export default function CareerCard({item}) {
  return (
    <TouchableWithoutFeedback>
      <View style={[t.mR6, t.bgWhite, t.roundedL, t.shadowLg, {shadowColor: themeColors.bgColor(0.2), shadowRadius: 7}]}>
        <Image style={[t.h50, t.w25, t.roundedTLg]} source={item.image}/>
        <View style={[t.pX3, t.pB4, t.flex1, t.itemsCenter]}>
          <Text style={[t.textLg, t.fontBold, t.pT2]}>{item.name}</Text>
        </View>
      </View>
    </TouchableWithoutFeedback>
  )
}