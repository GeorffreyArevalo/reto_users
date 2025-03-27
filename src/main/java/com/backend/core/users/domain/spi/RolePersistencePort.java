package com.backend.core.users.domain.spi;

import java.util.Optional;

import com.backend.core.users.domain.models.RoleModel;

public interface RolePersistencePort {
    
    Optional<RoleModel> saveRole(RoleModel role);

    Optional<RoleModel> findByName( String name );

}
