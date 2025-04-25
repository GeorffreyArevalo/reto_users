package com.backend.core.users.domain.exception;

public class UnAuthorizedException extends UserException{
    
    public UnAuthorizedException(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
