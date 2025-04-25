package com.backend.core.users.infrastructure.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.core.users.domain.exception.UserException;

import io.jsonwebtoken.JwtException;

@RestControllerAdvice
public class ExceptionHandlerController {
    

    @ExceptionHandler( exception = UserException.class )
    public ResponseEntity<ExceptionResponse> usersExceptionHandler( UserException exception ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().code( exception.getStatusCode() ).error( exception.getMessage() ).build();
        return ResponseEntity.status( exception.getStatusCode() ).body(exceptionResponse);
    }

    @ExceptionHandler( exception = JwtException.class )
    public ResponseEntity<ExceptionResponse> authorizationExceptionHandler( JwtException exception ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder().code( HttpStatus.UNAUTHORIZED.value() ).error( "No tiene permisos." ).build();
        return ResponseEntity.status( HttpStatus.UNAUTHORIZED ).body(exceptionResponse);
    }


}
