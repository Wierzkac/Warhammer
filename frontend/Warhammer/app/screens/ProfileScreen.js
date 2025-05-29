import { View, Text, TouchableOpacity, Image } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import Header from '../components/Header';
import ColorPicker from '../components/ColorPicker';
import { useTheme } from '../context/ThemeContext';

// Mock user data - in a real app, this would come from your auth system
const isLoggedIn = true;
const user = {
  name: "John Doe",
  email: "john@example.com",
  avatar: require('../assets/icon.png')
};

const ProfileContent = ({ navigation }) => {
  const { headerColor, setHeaderColor } = useTheme();

  if (!isLoggedIn) {
    return (
      <View style={[t.flex1, t.itemsCenter, t.justifyCenter, t.pX4]}>
        <Text style={[t.textXl, t.fontBold, t.mB6]}>Welcome to Warhammer</Text>
        <TouchableOpacity 
          style={[t.bgOrange500, t.pX8, t.pY3, t.roundedFull, t.mB4, t.wFull]}
          onPress={() => navigation.navigate('Login')}
        >
          <Text style={[t.textWhite, t.textCenter, t.fontBold]}>Login</Text>
        </TouchableOpacity>
        <TouchableOpacity 
          style={[t.border2, t.borderOrange500, t.pX8, t.pY3, t.roundedFull, t.wFull]}
          onPress={() => navigation.navigate('Register')}
        >
          <Text style={[t.textOrange500, t.textCenter, t.fontBold]}>Register</Text>
        </TouchableOpacity>
      </View>
    );
  }

  return (
    <View style={[t.flex1, t.itemsCenter, t.pT10]}>
      <Image 
        source={user.avatar}
        style={[t.w32, t.h32, t.roundedFull, t.mB4]}
      />
      <Text style={[t.textXl, t.fontBold, t.mB2]}>{user.name}</Text>
      <Text style={[t.textGray500, t.mB4]}>{user.email}</Text>

      <View style={[t.wFull, t.mT6]}>
        <Text style={[t.textLg, t.fontBold, t.mB2, t.textCenter]}>Theme Color</Text>
        <ColorPicker 
          selectedColor={headerColor}
          onSelectColor={setHeaderColor}
        />
      </View>

      <TouchableOpacity 
        style={[t.bgRed500, t.pX8, t.pY3, t.roundedFull, t.mT4]}
      >
        <Text style={[t.textWhite, t.fontBold]}>Logout</Text>
      </TouchableOpacity>
    </View>
  );
};

export default function ProfileScreen() {
  const navigation = useNavigation();

  return (
    <SafeAreaView style={[t.flex1, t.bgWhite]}>
      <Header showBack={true} />
      <View style={[t.flex1]}>
        <ProfileContent navigation={navigation} />
      </View>
    </SafeAreaView>
  );
} 