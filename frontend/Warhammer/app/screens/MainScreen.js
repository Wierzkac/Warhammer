import { ImageBackground, StatusBar, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'

export default function MainScreen() {
  return (
    <SafeAreaView>
      <StatusBar></StatusBar>
      <Text>Hello there!</Text>
    </SafeAreaView>
  )
}
