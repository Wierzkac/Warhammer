package com.warhammer.alfa.security.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AtLeastOneOfUsernameOrEmailValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastOneOfUsernameOrEmail {
    String message() default "Either username or email must be provided";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 