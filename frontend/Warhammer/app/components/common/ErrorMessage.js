import React from 'react';
import { View, Text, TouchableOpacity } from 'react-native';
import { t } from 'react-native-tailwindcss';
import { ERROR_MESSAGES } from '../../constants/constants';

const ErrorMessage = ({ message, onRetry }) => (
  <View style={[t.flex1, t.itemsCenter, t.justifyCenter, t.p4]}>
    <Text style={[t.textRed500, t.textCenter, t.mB4]}>
      {message || ERROR_MESSAGES.SERVER_ERROR}
    </Text>
    {onRetry && (
      <TouchableOpacity 
        onPress={onRetry}
        style={[t.bgBlue500, t.pX4, t.pY2, t.roundedLg]}
      >
        <Text style={[t.textWhite, t.fontBold]}>Retry</Text>
      </TouchableOpacity>
    )}
  </View>
);

export default ErrorMessage; 