import React, { useState } from 'react';
import { View, Text, TouchableOpacity, Alert } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useNavigation } from '@react-navigation/native';
import { ROUTES } from '../constants/constants';
import { required, password } from '../utils/validation';
import useForm from '../hooks/useForm';
import ScreenLayout from '../components/common/ScreenLayout';
import Input from '../components/common/Input';
import Button from '../components/common/Button';
import { useAuth } from '../context/AuthContext';
import { useTheme } from '../context/ThemeContext';
import { getStyles } from '../themes/styles';
import { encryptWithPublicKey } from '../services/api/encrypt';

const LoginScreen = () => {
  const navigation = useNavigation();
  const { login, error: authError, loading: authLoading } = useAuth();
  const [isLoading, setIsLoading] = useState(false);
  const { isDark } = useTheme();
  const styles = getStyles(isDark);

  const { values, errors, touched, handleChange, handleBlur, handleSubmit } = useForm(
    {
      username: '',
      password: '',
    },
    {
      username: [required],
      password: [required, password]
    }
  );

  const onSubmit = async (formValues) => {
    try {
      setIsLoading(true);
      let encryptedPassword;
      try {
        encryptedPassword = await encryptWithPublicKey(formValues.password);
      } catch (e) {
        Alert.alert('Encryption Error', 'Could not encrypt password.');
        setIsLoading(false);
        return;
      }
      await login({
        username: formValues.username,
        password: encryptedPassword
      });
      navigation.navigate(ROUTES.PROFILE);
    } catch (err) {
      Alert.alert('Login Failed', err.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <ScreenLayout showBack={true}>
      <View style={styles.container.screen}>
        <Text style={[styles.header.title, t.mB8, t.textCenter]}>
          Welcome Back
        </Text>

        <Input
          label="Email | Nickname"
          value={values.username}
          onChangeText={(text) => handleChange('username', text)}
          onBlur={() => handleBlur('username')}
          placeholder="Enter your email or nickname"
          keyboardType="email-address"
          error={touched.username && errors.username}
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
          <Text style={[styles.text.error, t.mT2, t.textCenter]}>
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
          <Text style={[styles.text.caption]}>Don't have an account? </Text>
          <TouchableOpacity onPress={() => navigation.navigate(ROUTES.REGISTER)}>
            <Text style={[styles.text.link, t.fontBold]}>Register</Text>
          </TouchableOpacity>
        </View>
      </View>
    </ScreenLayout>
  );
};

export default LoginScreen; 