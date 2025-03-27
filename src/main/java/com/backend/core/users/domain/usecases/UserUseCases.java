package com.backend.core.users.domain.usecases;

import java.util.List;

import com.backend.core.users.domain.api.UserServicePort;
import com.backend.core.users.domain.exception.BadRequestException;
import com.backend.core.users.domain.exception.DataNotFoundException;
import com.backend.core.users.domain.models.RoleModel;
import com.backend.core.users.domain.models.UserModel;
import com.backend.core.users.domain.spi.RolePersistencePort;
import com.backend.core.users.domain.spi.UserPersistencePort;

public class UserUseCases implements UserServicePort{

    private final UserPersistencePort userPersistencePort;
    private final RolePersistencePort rolePersistencePort;

    public UserUseCases(UserPersistencePort userPersistencePort, RolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void saveUser(UserModel user) {
        
        userPersistencePort.findByEmail(user.getEmail()).ifPresent((userFound) -> {
            throw new BadRequestException(400,  String.format("El usuario con email %s ya existe.", userFound.getEmail()));
        });
        userPersistencePort.saveUser(user);
    }

    @Override
    public UserModel findByEmail(String email) {
        UserModel user = userPersistencePort.findByEmail(email).orElseThrow(() -> new DataNotFoundException(404, "Usuario no encontrado."));
        return user;
    }

    @Override
    public List<UserModel> findByRole(String role) {
        RoleModel roleModel = rolePersistencePort.findByName(role).orElseThrow(() -> new DataNotFoundException(404, "El role enviado no existe."));
        return userPersistencePort.findByRole(roleModel.getId());
    }

    @Override
    public UserModel findById(Long id) {
        return userPersistencePort.findById(id).orElseThrow( () -> new DataNotFoundException(404, String.format("El usuario con id %s no existe.", id)) );
    }
    
}
