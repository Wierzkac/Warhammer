package com.warhammer.alfa.security.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AtLeastOneOfUsernameOrEmailValidator implements ConstraintValidator<AtLeastOneOfUsernameOrEmail, AuthenticationRequest> {
    @Override
    public boolean isValid(AuthenticationRequest value, ConstraintValidatorContext context) {
        return (value.getUsername() != null && !value.getUsername().isBlank())
            || (value.getEmail() != null && !value.getEmail().isBlank());
    }
} 