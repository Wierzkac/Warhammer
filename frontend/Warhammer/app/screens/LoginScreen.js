import React, { useState } from 'react';
import { View, Text, TouchableOpacity, Alert } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import { ROUTES } from '../constants/constants';
import { required, email } from '../utils/validation';
import useForm from '../hooks/useForm';
import ScreenLayout from '../components/common/ScreenLayout';
import Input from '../components/common/Input';
import Button from '../components/common/Button';
import { useAuth } from '../context/AuthContext';

const LoginScreen = () => {
  const navigation = useNavigation();
  const { login, error: authError } = useAuth();
  const [isLoading, setIsLoading] = useState(false);

  const { values, errors, touched, handleChange, handleBlur, handleSubmit } = useForm(
    {
      email: '',
      password: '',
    },
    {
      email: [required, email],
      password: [required],
    }
  );

  const onSubmit = async (formValues) => {
    try {
      setIsLoading(true);
      await login(formValues.email, formValues.password);
      navigation.navigate(ROUTES.PROFILE);
    } catch (err) {
      Alert.alert('Login Failed', err.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <ScreenLayout showBack={true}>
      <View style={[t.flex1, t.p4, t.justifyCenter]}>
        <Text style={[t.text3xl, t.fontBold, t.mB8, t.textCenter]}>
          Welcome Back
        </Text>

        <Input
          label="Email | Nickname"
          value={values.email}
          onChangeText={(text) => handleChange('email', text)}
          onBlur={() => handleBlur('email')}
          placeholder="Enter your email or nickname"
          keyboardType="email-address"
          error={touched.email && errors.email}
        />

        <Input
          label="Password"
          value={values.password}
          onChangeText={(text) => handleChange('password', text)}
          onBlur={() => handleBlur('password')}
          placeholder="Enter your password"
          secureTextEntry
          error={touched.password && errors.password}
        />

        {authError && (
          <Text style={[t.textRed500, t.mT2, t.textCenter]}>
            {authError}
          </Text>
        )}

        <Button
          title="Login"
          onPress={() => handleSubmit(onSubmit)}
          style={[t.mT4]}
          loading={isLoading}
        />

        <View style={[t.flexRow, t.justifyCenter, t.mT4]}>
          <Text style={[t.textGray600]}>Don't have an account? </Text>
          <TouchableOpacity onPress={() => navigation.navigate(ROUTES.REGISTER)}>
            <Text style={[t.textBlue500, t.fontBold]}>Register</Text>
          </TouchableOpacity>
        </View>
      </View>
    </ScreenLayout>
  );
};

export default LoginScreen; 