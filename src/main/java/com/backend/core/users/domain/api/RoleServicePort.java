package com.backend.core.users.domain.api;

import com.backend.core.users.domain.models.RoleModel;

public interface RoleServicePort {
    
    void saveRole(RoleModel role);

    RoleModel findByName(String name);

}
