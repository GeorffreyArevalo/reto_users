package com.backend.core.users.application.dtos.users;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {
    
    private String name;
    private String lastname;
    private String document;
    private String phone;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String roleName;

}
