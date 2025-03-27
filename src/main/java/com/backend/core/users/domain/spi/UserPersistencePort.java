package com.backend.core.users.domain.spi;

import java.util.List;
import java.util.Optional;

import com.backend.core.users.domain.models.UserModel;

public interface UserPersistencePort {
    
    Optional<UserModel> saveUser(UserModel user);

    Optional<UserModel> findByEmail( String email );

    Optional<UserModel> findById( Long id );

    List<UserModel> findByRole( Long idRole );

}
