import React, { useState, useEffect } from 'react';
import { View } from 'react-native';
import { useLanguage } from '../context/LanguageContext';
import { careers, talents, skills } from '../services/api/endpoints';
import ScreenLayout from '../components/common/ScreenLayout';
import FeatureRow from '../components/FeatureRow';
import ErrorMessage from '../components/common/ErrorMessage';
import LoadingSpinner from '../components/common/LoadingSpinner';

const MainScreen = () => {  
  const { language } = useLanguage();
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

  if (loading) return <LoadingSpinner />;
  if (error) return <ErrorMessage message={error.message} />;

  return (
    <ScreenLayout showProfile={true}>
      <View style={{ flex: 1 }}>
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
