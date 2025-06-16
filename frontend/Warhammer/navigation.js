import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { StyleSheet, View } from 'react-native';
import MainScreen from './app/screens/MainScreen';
import ProfileScreen from './app/screens/ProfileScreen';
import LoginScreen from './app/screens/LoginScreen';
import RegisterScreen from './app/screens/RegisterScreen';
import ItemsListScreen from './app/screens/ItemsListScreen';
import ItemDetailsScreen from './app/screens/ItemDetailsScreen';

const Stack = createNativeStackNavigator();

export default function Navigation() {
  return (
    <View style={styles.container}>
      <Stack.Navigator 
        screenOptions={{
          headerShown: false,
          contentStyle: { backgroundColor: 'transparent' }
        }}
      >
        <Stack.Screen name="Home" component={MainScreen} />
        <Stack.Screen name="Profile" component={ProfileScreen} />
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="Register" component={RegisterScreen} />
        <Stack.Screen name="ItemsList" component={ItemsListScreen} />
        <Stack.Screen name="ItemDetails" component={ItemDetailsScreen} />
      </Stack.Navigator>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'transparent'
  }
});