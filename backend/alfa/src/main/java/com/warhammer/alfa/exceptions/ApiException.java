package com.warhammer.alfa.exceptions;

public abstract class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
} 