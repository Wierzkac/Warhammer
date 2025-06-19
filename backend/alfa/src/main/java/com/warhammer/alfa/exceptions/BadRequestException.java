package com.warhammer.alfa.exceptions;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(message);
    }
} 