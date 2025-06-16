import { useCallback } from 'react';
import { useFormState } from './form/useFormState';
import { useFormValidation } from './form/useFormValidation';
import * as validators from '../utils/validation';

// Example of how to use validation rules with the existing validators
const createValidationRules = (rules) => {
  const validationRules = {};
  
  Object.entries(rules).forEach(([field, fieldRules]) => {
    validationRules[field] = fieldRules.map(rule => {
      if (typeof rule === 'function') {
        return rule;
      }
      
      // Handle rule objects with parameters
      if (rule.validator && rule.params) {
        return {
          validator: rule.validator,
          params: rule.params
        };
      }
      
      return rule;
    });
  });
  
  return validationRules;
};

const useForm = (initialValues = {}, validationRules = {}, formId = 'default') => {
  const {
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
  } = useFormState(initialValues, formId);

  const {
    errors,
    validateField,
    validateForm,
    setFieldError,
    clearErrors
  } = useFormValidation(validationRules);

  const handleChange = useCallback((name, value) => {
    setFieldValue(name, value);

    if (touched[name]) {
      const error = validateField(name, value, values);
      setFieldError(name, error);
    }
  }, [touched, validateField, setFieldValue, setFieldError, values]);

  const handleBlur = useCallback((name) => {
    setFieldTouched(name);
    const error = validateField(name, values[name], values);
    setFieldError(name, error);
  }, [validateField, setFieldTouched, setFieldError, values]);

  const handleSubmit = useCallback(async (onSubmit) => {
    setIsSubmitting(true);
    try {
      if (validateForm(values)) {
        await onSubmit(values);
      }
    } finally {
      setIsSubmitting(false);
    }
  }, [validateForm, values, setIsSubmitting]);

  return {
    values,
    errors,
    touched,
    isSubmitting,
    isValid,
    handleChange,
    handleBlur,
    handleSubmit,
    reset,
    setValues,
    setFieldValue,
    setFieldTouched,
    setFieldError,
    clearErrors
  };
};

export default useForm; 