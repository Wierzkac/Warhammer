package com.warhammer.alfa.exceptions;

public class AccountDisabledException extends BadRequestException {
    public AccountDisabledException(String message) {
        super(message);
    }
} 