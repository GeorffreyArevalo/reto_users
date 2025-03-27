package com.backend.core.users.application.handlers.role;

import com.backend.core.users.application.dtos.roles.CreateRoleRequest;
import com.backend.core.users.application.dtos.roles.RoleResponse;

public interface RoleHandler {
    
    void save(CreateRoleRequest role);

    RoleResponse findByName( String name );
    
}
