package com.warhammer.alfa.email.email_confirmation;

import com.warhammer.alfa.email.EmailArguments;

public record EmailConfirmationArguments(String username, String confirmationUrl, Integer expiryMinutes) implements EmailArguments {}