package com.backend.core.users.infrastructure.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.core.users.domain.exception.UserException;

@RestControllerAdvice
public class ExceptionHandlerController {
    

    @ExceptionHandler( exception = UserException.class )
    public ResponseEntity<ExceptionResponse> usersExceptionHandler( UserException exception ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().code( exception.getStatusCode() ).error( exception.getMessage() ).build();
        return ResponseEntity.status( exception.getStatusCode() ).body(exceptionResponse);
    }


}
