package com.backend.core.users.infrastructure.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.core.users.application.dtos.roles.CreateRoleRequest;
import com.backend.core.users.application.dtos.roles.RoleResponse;
import com.backend.core.users.application.handlers.role.RoleHandler;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    
    private final RoleHandler roleHandler;

    @GetMapping("/{name}")
    public ResponseEntity<RoleResponse> getById(@PathVariable( name = "name" ) String name) {
        return ResponseEntity.ok( roleHandler.findByName(name) );
    }
    

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateRoleRequest createRoleRequest) {
        roleHandler.save(createRoleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    

}
