package com.backend.core.users.application.handlers.auth;

import com.backend.core.users.application.dtos.users.LoginRequest;
import com.backend.core.users.application.dtos.users.LoginResponse;

public interface AuthHandler {
    
    LoginResponse login(LoginRequest user);

    LoginResponse validateToken(String token);

}
