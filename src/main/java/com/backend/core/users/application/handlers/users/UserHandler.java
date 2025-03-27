package com.backend.core.users.application.handlers.users;

import com.backend.core.users.application.dtos.users.CreateUserRequest;

public interface UserHandler {
    
    void saveUser( CreateUserRequest userRequest );

}
