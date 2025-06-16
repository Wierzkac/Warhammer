import { useState, useEffect, useCallback } from 'react';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { debounce } from 'lodash';

const STORAGE_KEY_PREFIX = '@form_state_';

export const useFormState = (initialValues = {}, formId = 'default') => {
  const [values, setValues] = useState(initialValues);
  const [touched, setTouched] = useState({});
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [isValid, setIsValid] = useState(false);

  // Load saved form state
  useEffect(() => {
    const loadSavedState = async () => {
      try {
        const savedState = await AsyncStorage.getItem(`${STORAGE_KEY_PREFIX}${formId}`);
        if (savedState) {
          const { values: savedValues, touched: savedTouched } = JSON.parse(savedState);
          setValues(savedValues);
          setTouched(savedTouched);
        }
      } catch (error) {
        console.error('Error loading form state:', error);
      }
    };
    loadSavedState();
  }, [formId]);

  // Save form state
  const saveFormState = useCallback(async (newValues, newTouched) => {
    try {
      await AsyncStorage.setItem(
        `${STORAGE_KEY_PREFIX}${formId}`,
        JSON.stringify({ values: newValues, touched: newTouched })
      );
    } catch (error) {
      console.error('Error saving form state:', error);
    }
  }, [formId]);

  // Debounced save
  const debouncedSave = useCallback(
    debounce((newValues, newTouched) => {
      saveFormState(newValues, newTouched);
    }, 1000),
    [saveFormState]
  );

  const setFieldValue = useCallback((name, value) => {
    setValues(prev => {
      const newValues = { ...prev, [name]: value };
      debouncedSave(newValues, touched);
      return newValues;
    });
  }, [touched, debouncedSave]);

  const setFieldTouched = useCallback((name) => {
    setTouched(prev => {
      const newTouched = { ...prev, [name]: true };
      debouncedSave(values, newTouched);
      return newTouched;
    });
  }, [values, debouncedSave]);

  const reset = useCallback(async () => {
    setValues(initialValues);
    setTouched({});
    setIsValid(false);
    setIsSubmitting(false);
    await AsyncStorage.removeItem(`${STORAGE_KEY_PREFIX}${formId}`);
  }, [initialValues, formId]);

  return {
    values,
    touched,
    isSubmitting,
    isValid,
    setValues,
    setFieldValue,
    setFieldTouched,
    setIsSubmitting,
    setIsValid,
    reset
  };
}; 