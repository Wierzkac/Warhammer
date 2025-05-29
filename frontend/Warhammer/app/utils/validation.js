export const required = (value) => {
  if (!value || value.trim() === '') {
    return 'This field is required';
  }
  return '';
};

export const email = (value) => {
  if (!value) return '';
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(value)) {
    return 'Please enter a valid email address';
  }
  return '';
};

export const minLength = (min) => (value) => {
  if (!value) return '';
  if (value.length < min) {
    return `Must be at least ${min} characters`;
  }
  return '';
};

export const maxLength = (max) => (value) => {
  if (!value) return '';
  if (value.length > max) {
    return `Must be no more than ${max} characters`;
  }
  return '';
};

export const password = (value) => {
  if (!value) return '';
  if (value.length < 8) {
    return 'Password must be at least 8 characters';
  }
  if (!/[A-Z]/.test(value)) {
    return 'Password must contain at least one uppercase letter';
  }
  if (!/[a-z]/.test(value)) {
    return 'Password must contain at least one lowercase letter';
  }
  if (!/[0-9]/.test(value)) {
    return 'Password must contain at least one number';
  }
  return '';
};

export const match = (field, fieldName) => (value, values) => {
  if (!value) return '';
  if (value !== values[field]) {
    return `Must match ${fieldName}`;
  }
  return '';
};

export const number = (value) => {
  if (!value) return '';
  if (isNaN(value)) {
    return 'Must be a number';
  }
  return '';
};

export const positive = (value) => {
  if (!value) return '';
  if (Number(value) <= 0) {
    return 'Must be greater than 0';
  }
  return '';
}; 