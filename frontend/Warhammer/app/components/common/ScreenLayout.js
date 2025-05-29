import React from 'react';
import { View, ScrollView } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { t } from 'react-native-tailwindcss';
import Header from '../Header';
import LoadingSpinner from './LoadingSpinner';
import ErrorMessage from './ErrorMessage';

const ScreenLayout = ({ 
  children, 
  showHeader = true, 
  showProfile = false,
  loading = false,
  error = null,
  onRetry,
  scrollable = true,
  style = []
}) => {
  const content = (
    <>
      {showHeader && <Header showProfile={showProfile} />}
      {loading ? (
        <LoadingSpinner />
      ) : error ? (
        <ErrorMessage message={error} onRetry={onRetry} />
      ) : (
        children
      )}
    </>
  );

  return (
    <SafeAreaView style={[t.flex1, t.bgGray50, ...style]}>
      {scrollable ? (
        <ScrollView 
          showsVerticalScrollIndicator={false}
          contentContainerStyle={[t.flexGrow]}
        >
          {content}
        </ScrollView>
      ) : (
        content
      )}
    </SafeAreaView>
  );
};

export default ScreenLayout; 