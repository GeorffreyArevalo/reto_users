package com.backend.core.users.infrastructure.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.core.users.application.dtos.users.CreateUserRequest;
import com.backend.core.users.application.handlers.users.UserHandler;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    
    private final UserHandler userHandler;

    @PostMapping("/create/owner")
    public ResponseEntity<Void> create(@RequestBody CreateUserRequest createUserRequest) {
        createUserRequest.setRoleName("ROLE_OWNER");
        userHandler.saveUser(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    

}
