package com.backend.core.users.domain.api;

import java.util.List;

import com.backend.core.users.domain.models.UserModel;

public interface UserServicePort {

    void saveUser( UserModel user );

    UserModel findByEmail( String email );

    List<UserModel> findByRole( String role );
    
}
