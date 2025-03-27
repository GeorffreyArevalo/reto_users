package com.backend.core.users.domain.exception;

public class BadRequestException extends UserException {

    public BadRequestException(Integer statusCode, String message) {
        super(statusCode, message);
    }
}

