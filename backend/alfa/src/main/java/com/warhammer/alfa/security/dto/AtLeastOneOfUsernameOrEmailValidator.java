package com.warhammer.alfa.security.dto;

import org.mapstruct.ap.internal.util.Strings;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AtLeastOneOfUsernameOrEmailValidator implements ConstraintValidator<AtLeastOneOfUsernameOrEmail, AuthenticationRequest> {
    @Override
    public boolean isValid(AuthenticationRequest value, ConstraintValidatorContext context) {
        return !Strings.isEmpty(value.getUsername()) || !Strings.isEmpty(value.getEmail());
    }
} 