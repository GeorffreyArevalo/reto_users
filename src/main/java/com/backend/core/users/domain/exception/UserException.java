package com.backend.core.users.domain.exception;

public class UserException extends RuntimeException{
    
    private final Integer statusCode;

    public UserException(Integer statusCode, String message) {
        super(message); 
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

}
