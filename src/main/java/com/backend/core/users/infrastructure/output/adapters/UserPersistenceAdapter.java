package com.backend.core.users.infrastructure.output.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.backend.core.users.domain.models.UserModel;
import com.backend.core.users.domain.spi.UserPersistencePort;
import com.backend.core.users.infrastructure.output.entities.UserEntity;
import com.backend.core.users.infrastructure.output.mappers.UserEntityMapper;
import com.backend.core.users.infrastructure.output.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort{

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<UserModel> saveUser(UserModel user) {
        UserEntity entity = userEntityMapper.modelToEntity(user);
        UserEntity entitySaved = userRepository.save(entity);
        return Optional.of(userEntityMapper.entityToModel(entitySaved));
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        UserEntity entity = userRepository.findByEmail(email).orElse(null);
        return Optional.of(userEntityMapper.entityToModel(entity));
    }

    @Override
    public List<UserModel> findByRole(Long roleId) {
        return userEntityMapper.listEntityToModel(userRepository.findByRoleId(roleId));
    }
    
}
