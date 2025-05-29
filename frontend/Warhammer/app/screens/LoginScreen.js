import React from 'react';
import { View, Text, TouchableOpacity } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import { ROUTES } from '../constants/constants';
import { required, email } from '../utils/validation';
import useForm from '../hooks/useForm';
import ScreenLayout from '../components/common/ScreenLayout';
import Input from '../components/common/Input';
import Button from '../components/common/Button';

const LoginScreen = () => {
  const navigation = useNavigation();
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

  const onSubmit = (formValues) => {
    // TODO: Implement login logic
    console.log('Login values:', formValues);
  };

  return (
    <ScreenLayout showHeader={false}>
      <View style={[t.flex1, t.p4, t.justifyCenter]}>
        <Text style={[t.text3xl, t.fontBold, t.mB8, t.textCenter]}>
          Welcome Back
        </Text>

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
          placeholder="Enter your password"
          secureTextEntry
          error={touched.password && errors.password}
        />

        <Button
          title="Login"
          onPress={() => handleSubmit(onSubmit)}
          style={[t.mT4]}
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