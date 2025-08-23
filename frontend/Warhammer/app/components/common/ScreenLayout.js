import React from 'react';
import { View, ScrollView, ImageBackground } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { t } from 'react-native-tailwindcss';
import { useTheme } from '../../context/ThemeContext';
import Header from '../Header';
import LoadingSpinner from './LoadingSpinner';
import ErrorMessage from './ErrorMessage';

const ScreenLayout = ({ 
  children, 
  showHeader = true, 
  showProfile = false,
  showBack = false,
  loading = false,
  error = null,
  onRetry,
  scrollable = true,
  style = []
}) => {
  const { currentTheme, isDark } = useTheme();

  const content = (
    <>
      {showHeader && <Header showProfile={showProfile} showBack={showBack} />}
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
    <View style={{ flex: 1 }}>
      <ImageBackground
        source={require('../../assets/background.png')}
        style={{ 
          position: 'absolute',
          top: 0,
          left: 0,
          right: 0,
          bottom: 0,
          width: '100%',
          height: '100%'
        }}
        imageStyle={{ 
          width: '100%',
          height: '100%',
          resizeMode: 'repeat'
        }}
      >
        {/* Theme overlay */}
        <View style={{
          position: 'absolute',
          top: 0,
          left: 0,
          right: 0,
          bottom: 0,
          backgroundColor: isDark 
            ? 'rgba(15, 23, 42, 0.8)' // Dark overlay
            : 'rgba(255, 255, 255, 0.9)', // Light overlay
        }} />
      </ImageBackground>
      <SafeAreaView style={[t.flex1, ...style]}>
        {scrollable ? (
          <ScrollView 
            showsVerticalScrollIndicator={false}
            contentContainerStyle={[t.flexGrow]}
            stickyHeaderIndices={[0]}
            maximumZoomScale={1.0}
            minimumZoomScale={1.0}
            bounces={false}
            bouncesZoom={false}
          >
            {content}
          </ScrollView>
        ) : (
          content
        )}
      </SafeAreaView>
    </View>
  );
};

export default ScreenLayout; 