import React from 'react';
import { View, TextInput, Text } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { useTheme } from '../../context/ThemeContext';
import { getStyles } from '../../themes/styles';

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
  onBlur,
}) => {
  const { isDark } = useTheme();
  const styles = getStyles(isDark);

  return (
    <View style={[t.mB4, ...style]}>
      {label && (
        <Text style={styles.input.label}>
          {label}
        </Text>
      )}
      <TextInput
        value={value}
        onChangeText={onChangeText}
        onBlur={onBlur}
        placeholder={placeholder}
        secureTextEntry={secureTextEntry}
        keyboardType={keyboardType}
        autoCapitalize={autoCapitalize}
        multiline={multiline}
        numberOfLines={numberOfLines}
        style={[
          styles.input.base,
          error && styles.input.error,
          multiline && t.h24,
          ...inputStyle,
        ]}
        placeholderTextColor={styles.text.caption[2].color}
      />
      {error && (
        <Text style={styles.text.error}>
          {error}
        </Text>
      )}
    </View>
  );
};

export default Input; 