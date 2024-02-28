import { ImageBackground, ScrollView, StatusBar, StyleSheet, Text, TextInput, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import { t } from 'react-native-tailwindcss';
import * as Icon from "react-native-feather";
import { careers } from '../assets/placeholders'
import FeatureRow from '../components/FeatureRow'


export default function MainScreen() {
  return (
    <SafeAreaView style={[t.bgWhite]}>
      <StatusBar style={[t.darkContent]}></StatusBar>

      {/* Search bar */}
      <View style={[t.flexRow, t.itemsCenter, t.spaceX2, t.pX4, t.pB2]}>
        <View style={[t.flexRow, t.flex1, t.itemsCenter, t.p3, t.roundedFull, t.border, t.borderGray300]}>
          <Icon.Search width="25" height="25" stroke="grey"></Icon.Search>
          <TextInput placeholder='' style={[t.mL2, t.flex1]}/>
        </View>
      </View>
      
      {/* Main View */}
      <ScrollView 
        showsVerticalScrollIndicator={false}
        contentContainerStyle={{
          paddingBottom: 20
        }}>

        {/* Careers */}
        {/* Skills */}
        {/* Talents */}
        {/* Items */}
        {/* Spells */}
        <View style={[t.mT5]}>
          {
            [careers, careers, careers, careers, careers, careers, careers, careers, careers].map((item, index) => {
              return (
                <FeatureRow
                  key={index}
                  title={item.title}
                  items={item.items}
                  description={item.description}
                />
            )
            })
          }
        </View>
        

      </ScrollView>
    </SafeAreaView>
  )
}
