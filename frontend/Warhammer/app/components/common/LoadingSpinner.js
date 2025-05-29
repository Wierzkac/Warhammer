import React from 'react';
import { View, ActivityIndicator } from 'react-native';
import { t } from 'react-native-tailwindcss';

const LoadingSpinner = ({ size = 'large', color = '#0000ff' }) => (
  <View style={[t.flex1, t.itemsCenter, t.justifyCenter]}>
    <ActivityIndicator size={size} color={color} />
  </View>
);

export default LoadingSpinner; 