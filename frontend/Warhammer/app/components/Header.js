import { View, TouchableOpacity, Image } from 'react-native'
import React from 'react'
import { t } from 'react-native-tailwindcss';
import * as Icon from "react-native-feather";
import { useNavigation } from '@react-navigation/native';
import { useTheme } from '../context/ThemeContext';

const Header = ({ showBack = false, showProfile = false }) => {
  const navigation = useNavigation();
  const { headerColor } = useTheme();

  return (
    <View style={[
      t.flexRow, 
      t.justifyBetween, 
      t.itemsCenter, 
      t.wFull, 
      t.pX4, 
      t.pY3,
      { backgroundColor: headerColor }
    ]}>
      <View style={[t.w10, t.h10, t.itemsCenter, t.justifyCenter]}>
        {showBack && (
          <TouchableOpacity 
            onPress={() => navigation.goBack()}
            style={[t.itemsCenter, t.justifyCenter]}
          >
            <Icon.ArrowLeft width="24" height="24" stroke="white" />
          </TouchableOpacity>
        )}
      </View>

      <View style={[t.flex1, t.itemsCenter]}>
        {/* Add title or logo here if needed */}
      </View>

      <View style={[t.w10, t.h10, t.itemsCenter, t.justifyCenter]}>
        {showProfile && (
          <TouchableOpacity 
            onPress={() => navigation.navigate('Profile')}
            style={[t.itemsCenter, t.justifyCenter]}
          >
            <Image 
              source={require('../assets/icon.png')}
              style={[t.w10, t.h10, t.roundedFull]}
            />
          </TouchableOpacity>
        )}
      </View>
    </View>
  );
};

export default Header; 