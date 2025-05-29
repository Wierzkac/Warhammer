import { View, Text, TouchableOpacity, TextInput } from 'react-native'
import React, { useState } from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import Header from '../components/Header';

export default function RegisterScreen() {
  const navigation = useNavigation();
  const [nickname, setNickname] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleRegister = () => {
    // TODO: Implement actual registration logic
    console.log('Register attempt:', { nickname, email, password });
  };

  return (
    <SafeAreaView style={[t.flex1, t.bgWhite]}>
      <Header showBack={true} />
      
      <View style={[t.flex1, t.pX6, t.justifyCenter]}>
        <Text style={[t.text2xl, t.fontBold, t.mB8, t.textCenter]}>Register</Text>
        
        <View style={[t.mB4]}>
          <Text style={[t.textGray600, t.mB2]}>Nickname</Text>
          <TextInput
            style={[t.border, t.borderGray300, t.roundedLg, t.pX4, t.pY3]}
            placeholder="Choose a nickname"
            value={nickname}
            onChangeText={setNickname}
            autoCapitalize="none"
          />
        </View>

        <View style={[t.mB4]}>
          <Text style={[t.textGray600, t.mB2]}>Email</Text>
          <TextInput
            style={[t.border, t.borderGray300, t.roundedLg, t.pX4, t.pY3]}
            placeholder="Enter your email"
            value={email}
            onChangeText={setEmail}
            autoCapitalize="none"
            keyboardType="email-address"
          />
        </View>

        <View style={[t.mB6]}>
          <Text style={[t.textGray600, t.mB2]}>Password</Text>
          <TextInput
            style={[t.border, t.borderGray300, t.roundedLg, t.pX4, t.pY3]}
            placeholder="Create a password"
            value={password}
            onChangeText={setPassword}
            secureTextEntry
          />
        </View>

        <TouchableOpacity 
          style={[t.bgOrange500, t.pY3, t.roundedFull, t.mB4]}
          onPress={handleRegister}
        >
          <Text style={[t.textWhite, t.textCenter, t.fontBold]}>Register</Text>
        </TouchableOpacity>

        <TouchableOpacity 
          onPress={() => navigation.navigate('Login')}
          style={[t.itemsCenter]}
        >
          <Text style={[t.textOrange500]}>Already have an account? Login</Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
} 