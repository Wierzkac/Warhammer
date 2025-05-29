import { View, TouchableOpacity } from 'react-native'
import React from 'react'
import { t } from 'react-native-tailwindcss';
import { themeColors } from '../context/ThemeContext';

const ColorPicker = ({ selectedColor, onSelectColor }) => {
  return (
    <View style={[t.flexRow, t.flexWrap, t.justifyCenter, t.gap2, t.p4]}>
      {Object.entries(themeColors).map(([name, color]) => (
        <TouchableOpacity
          key={name}
          onPress={() => onSelectColor(color)}
          style={[
            t.w8,
            t.h8,
            t.roundedFull,
            { backgroundColor: color },
            selectedColor === color && t.border2,
            selectedColor === color && t.borderWhite,
            t.shadowMd
          ]}
        />
      ))}
    </View>
  );
};

export default ColorPicker; 