package com.backend.core.users.application.handlers.users;

import com.backend.core.users.application.dtos.users.CreateUserRequest;
import com.backend.core.users.application.dtos.users.UserResponse;

public interface UserHandler {
    
    void saveUser( CreateUserRequest userRequest );

    UserResponse findById(Long id);

}
