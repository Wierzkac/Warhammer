import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { useLanguage } from '../context/LanguageContext';
import { useTheme } from '../context/ThemeContext';
import { careers, talents, skills } from '../services/api/endpoints';
import ScreenLayout from '../components/common/ScreenLayout';
import FeatureRow from '../components/FeatureRow';

const MainScreen = () => {  
  const { language } = useLanguage();
  const { currentTheme, isDark } = useTheme();
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [data, setData] = useState({
    careers: [],
    talents: [],
    skills: []
  });

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        const [careersData, talentsData, skillsData] = await Promise.all([
          careers.getAll(language),
          talents.getAll(language),
          skills.getAll(language)
        ]);
        
        setData({
          careers: careersData,
          talents: talentsData,
          skills: skillsData
        });
      } catch (err) {
        setError(err);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [language]);

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      padding: 16,
    },
    welcomeSection: {
      marginBottom: 24,
    },
    welcomeTitle: {
      fontSize: 24,
      fontWeight: 'bold',
      color: currentTheme.text,
      marginBottom: 8,
    },
    welcomeSubtitle: {
      fontSize: 16,
      color: currentTheme.textSecondary,
      marginBottom: 16,
    },
    welcomeText: {
      fontSize: 14,
      color: currentTheme.text,
      lineHeight: 20,
    },
    themeSection: {
      marginBottom: 24,
    },
    themeCard: {
      backgroundColor: currentTheme.surface,
      borderRadius: 12,
      padding: 20,
      marginBottom: 16,
      shadowColor: isDark ? '#000' : '#000',
      shadowOffset: { width: 0, height: 2 },
      shadowOpacity: isDark ? 0.3 : 0.1,
      shadowRadius: 8,
      elevation: 4,
    },
    themeTitle: {
      fontSize: 18,
      fontWeight: '600',
      color: currentTheme.primary,
      marginBottom: 12,
    },
    themeText: {
      fontSize: 14,
      color: currentTheme.text,
      lineHeight: 20,
    },
  });

  return (
    <ScreenLayout 
      showProfile={true}
      loading={loading}
      error={error?.message}
      onRetry={() => {
        setError(null);
        setLoading(true);
        fetchData();
      }}
    >
      <View style={styles.container}>
        {/* Welcome Section */}
        <View style={styles.welcomeSection}>
          <Text style={styles.welcomeTitle}>Welcome to the Old World</Text>
          <Text style={styles.welcomeSubtitle}>
            Create your hero in the grim world of Warhammer Fantasy
          </Text>
          <Text style={styles.welcomeText}>
            Choose your race, career, and develop your character through adventures in the Empire.
          </Text>
        </View>

        {/* Theme Information Section */}
        <View style={styles.themeSection}>
          <Text style={styles.themeTitle}>Theme Mode</Text>
          <View style={styles.themeCard}>
            <Text style={styles.themeTitle}>
              {isDark ? 'Dark Mode Active' : 'Light Mode Active'}
            </Text>
            <Text style={styles.themeText}>
              You can toggle between light and dark themes using the theme button in the header.
              The current theme is automatically saved and will persist between app sessions.
            </Text>
          </View>
        </View>

        {/* Original Data Sections */}
        {data.careers.length > 0 && (
          <FeatureRow
            title="Careers"
            items={data.careers}
            type="Career"
          />
        )}
        {data.talents.length > 0 && (
          <FeatureRow
            title="Talents"
            items={data.talents}
            type="Talent"
          />
        )}
        {data.skills.length > 0 && (
          <FeatureRow
            title="Skills"
            items={data.skills}
            type="Skill"
          />
        )}
      </View>
    </ScreenLayout>
  );
};

export default MainScreen;
