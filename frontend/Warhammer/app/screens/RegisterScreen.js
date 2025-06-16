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

const RegisterScreen = () => {
  const navigation = useNavigation();
  const { register, error: authError } = useAuth();
  const [isLoading, setIsLoading] = useState(false);

  const { values, errors, touched, handleChange, handleBlur, handleSubmit } = useForm(
    {
      nickname: '',
      email: '',
      password: '',
      confirmPassword: '',
    },
    {
      nickname: [required],
      email: [required, email],
      password: [required],
      confirmPassword: [required, (value) => value === values.password || 'Passwords do not match'],
    }
  );

  const onSubmit = async (formValues) => {
    try {
      setIsLoading(true);
      await register(formValues.nickname, formValues.email, formValues.password);
      navigation.navigate(ROUTES.PROFILE);
    } catch (err) {
      Alert.alert('Registration Failed', err.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <ScreenLayout showBack={true}>
      <View style={[t.flex1, t.p4, t.justifyCenter]}>
        <Text style={[t.text3xl, t.fontBold, t.mB8, t.textCenter]}>
          Create Account
        </Text>

        <Input
          label="Nickname"
          value={values.nickname}
          onChangeText={(text) => handleChange('nickname', text)}
          onBlur={() => handleBlur('nickname')}
          placeholder="Choose a nickname"
          error={touched.nickname && errors.nickname}
        />

        <Input
          label="Email"
          value={values.email}
          onChangeText={(text) => handleChange('email', text)}
          onBlur={() => handleBlur('email')}
          placeholder="Enter your email"
          keyboardType="email-address"
          error={touched.email && errors.email}
        />

        <Input
          label="Password"
          value={values.password}
          onChangeText={(text) => handleChange('password', text)}
          onBlur={() => handleBlur('password')}
          placeholder="Create a password"
          secureTextEntry
          error={touched.password && errors.password}
        />

        <Input
          label="Confirm Password"
          value={values.confirmPassword}
          onChangeText={(text) => handleChange('confirmPassword', text)}
          onBlur={() => handleBlur('confirmPassword')}
          placeholder="Confirm your password"
          secureTextEntry
          error={touched.confirmPassword && errors.confirmPassword}
        />

        {authError && (
          <Text style={[t.textRed500, t.mT2, t.textCenter]}>
            {authError}
          </Text>
        )}

        <Button
          title="Register"
          onPress={() => handleSubmit(onSubmit)}
          style={[t.mT4]}
          loading={isLoading}
        />

        <View style={[t.flexRow, t.justifyCenter, t.mT4]}>
          <Text style={[t.textGray600]}>Already have an account? </Text>
          <TouchableOpacity onPress={() => navigation.navigate(ROUTES.LOGIN)}>
            <Text style={[t.textBlue500, t.fontBold]}>Login</Text>
          </TouchableOpacity>
        </View>
      </View>
    </ScreenLayout>
  );
};

export default RegisterScreen; 