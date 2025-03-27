package com.backend.core.users.domain.usecases;

import com.backend.core.users.domain.api.RoleServicePort;
import com.backend.core.users.domain.exception.DataNotFoundException;
import com.backend.core.users.domain.models.RoleModel;
import com.backend.core.users.domain.spi.RolePersistencePort;

public class RoleUseCases implements RoleServicePort{

    private final RolePersistencePort rolePersistencePort;

    public RoleUseCases(RolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void saveRole(RoleModel role) {
        rolePersistencePort.saveRole(role);
    }

    @Override
    public RoleModel findByName(String name) {
        RoleModel role = rolePersistencePort.findByName(name).orElseThrow(() -> new DataNotFoundException(404, "Rol no encontrado."));
        return role;
    }
    
}
