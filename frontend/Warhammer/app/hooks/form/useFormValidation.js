import { useState, useCallback } from 'react';
import * as validators from '../../utils/validation';

export const useFormValidation = (validationRules = {}) => {
  const [errors, setErrors] = useState({});

  const validateField = useCallback((name, value, values) => {
    if (!validationRules[name]) return '';

    const rules = validationRules[name];
    for (const rule of rules) {
      // Handle both direct validator functions and validator functions with parameters
      const validator = typeof rule === 'function' ? rule : rule.validator;
      const params = rule.params || [];
      const error = validator(value, values, ...params);
      if (error) return error;
    }
    return '';
  }, [validationRules]);

  const validateForm = useCallback((values) => {
    const newErrors = {};
    let isValid = true;

    Object.keys(validationRules).forEach(name => {
      const error = validateField(name, values[name], values);
      if (error) {
        newErrors[name] = error;
        isValid = false;
      }
    });

    setErrors(newErrors);
    return isValid;
  }, [validateField]);

  const setFieldError = useCallback((name, error) => {
    setErrors(prev => ({ ...prev, [name]: error }));
  }, []);

  const clearErrors = useCallback(() => {
    setErrors({});
  }, []);

  return {
    errors,
    validateField,
    validateForm,
    setFieldError,
    clearErrors,
    validators // Export validators for convenience
  };
}; 