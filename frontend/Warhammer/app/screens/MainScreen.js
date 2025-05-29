import React from 'react';
import { ROUTES } from '../constants/constants';
import useFetch from '../hooks/useFetch';
import { fetchCareers, fetchTalents, fetchSkills } from '../services/api';
import ScreenLayout from '../components/common/ScreenLayout';
import FeatureRow from '../components/FeatureRow';

const MainScreen = ({ navigation }) => {
  const { data: careers, loading: careersLoading, error: careersError } = useFetch(fetchCareers);
  const { data: talents, loading: talentsLoading, error: talentsError } = useFetch(fetchTalents);
  const { data: skills, loading: skillsLoading, error: skillsError } = useFetch(fetchSkills);

  const loading = careersLoading || talentsLoading || skillsLoading;
  const error = careersError || talentsError || skillsError;

  const handleSeeAll = (items, title) => {
    navigation.navigate(ROUTES.ITEMS_LIST, { items, title });
  };

  return (
    <ScreenLayout
      showProfile={true}
      loading={loading}
      error={error}
    >
      {/* Careers Section */}
      <FeatureRow
        title="Careers"
        description="Choose your path"
        items={careers || []}
      />

      {/* Talents Section */}
      <FeatureRow
        title="Talents"
        description="Discover your abilities"
        items={talents || []}
      />

      {/* Skills Section */}
      <FeatureRow
        title="Skills"
        description="Master your craft"
        items={skills || []}
      />
    </ScreenLayout>
  );
};

export default MainScreen;
