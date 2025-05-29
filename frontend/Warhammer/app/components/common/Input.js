import React from 'react';
import { View, TextInput, Text } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { colors } from '../../theme/styles';

const Input = ({
  value,
  onChangeText,
  placeholder,
  label,
  error,
  secureTextEntry = false,
  keyboardType = 'default',
  autoCapitalize = 'none',
  style = [],
  inputStyle = [],
  multiline = false,
  numberOfLines = 1,
}) => {
  return (
    <View style={[t.mB4, ...style]}>
      {label && (
        <Text style={[t.textGray700, t.mB1, t.fontMedium]}>
          {label}
        </Text>
      )}
      <TextInput
        value={value}
        onChangeText={onChangeText}
        placeholder={placeholder}
        secureTextEntry={secureTextEntry}
        keyboardType={keyboardType}
        autoCapitalize={autoCapitalize}
        multiline={multiline}
        numberOfLines={numberOfLines}
        style={[
          t.bgWhite,
          t.p3,
          t.roundedLg,
          t.border,
          t.borderGray300,
          error && { borderColor: colors.danger },
          multiline && t.h24,
          ...inputStyle,
        ]}
        placeholderTextColor={colors.secondary}
      />
      {error && (
        <Text style={[t.textRed500, t.textSm, t.mT1]}>
          {error}
        </Text>
      )}
    </View>
  );
};

export default Input; 