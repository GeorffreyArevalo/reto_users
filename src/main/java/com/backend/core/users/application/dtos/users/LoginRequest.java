package com.backend.core.users.application.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    
    private String email;
    private String password;

    public void validate() {
        // TODO: Validate
    }
}
