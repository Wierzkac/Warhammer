import { View, Text, TouchableOpacity, Image } from 'react-native'
import React from 'react'
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import ScreenLayout from '../components/common/ScreenLayout';
import ColorPicker from '../components/ColorPicker';
import { useTheme } from '../context/ThemeContext';
import { useAuth } from '../context/AuthContext';

const ProfileContent = ({ navigation }) => {
  const { headerColor, setHeaderColor } = useTheme();
  const { user, logout } = useAuth();

  if (!user) {
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
    <View style={[t.flex1, t.p4]}>
      <View style={[t.itemsCenter, t.mB8]}>
        <Image
          source={user.profileImageUrl ? { uri: user.profileImageUrl } : require('../assets/icon.png')}
          style={[t.w24, t.h24, t.roundedFull, t.mB4]}
        />
        <Text style={[t.textXl, t.fontBold]}>{user.nickname}</Text>
        <Text style={[t.textGray600]}>{user.email}</Text>
      </View>

      <View style={[t.mB8]}>
        <Text style={[t.textLg, t.fontBold, t.mB4]}>Theme Color</Text>
        <ColorPicker
          selectedColor={headerColor}
          onSelectColor={setHeaderColor}
        />
      </View>

      <TouchableOpacity 
        style={[t.bgRed500, t.pX8, t.pY3, t.roundedFull, t.wFull]}
        onPress={logout}
      >
        <Text style={[t.textWhite, t.textCenter, t.fontBold]}>Logout</Text>
      </TouchableOpacity>
    </View>
  );
};

export default function ProfileScreen() {
  const navigation = useNavigation();
  return (
    <ScreenLayout showProfile={false} showBack={true}>
      <ProfileContent navigation={navigation} />
    </ScreenLayout>
  );
} 