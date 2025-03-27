package com.backend.core.users.domain.exception;

public class DataNotFoundException extends UserException{

    public DataNotFoundException(Integer statusCode, String message) {
        super(statusCode, message);
    }
    
}
