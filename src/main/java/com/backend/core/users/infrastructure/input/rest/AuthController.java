package com.backend.core.users.infrastructure.input.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.core.users.application.dtos.users.LoginRequest;
import com.backend.core.users.application.dtos.users.LoginResponse;
import com.backend.core.users.application.handlers.auth.AuthHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthHandler authHandler;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest user) {
        return ResponseEntity.ok( authHandler.login(user) );
    }

    @GetMapping("/validate")
    public ResponseEntity<LoginResponse> validateToken(@RequestHeader( name = "Authorization" ) String token) {
        return ResponseEntity.ok( authHandler.validateToken(token) );
    }
    


}
