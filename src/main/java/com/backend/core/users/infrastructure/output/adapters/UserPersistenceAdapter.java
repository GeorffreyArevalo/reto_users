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
        Optional<UserEntity> entity = userRepository.findByEmail(email);
        if( entity.isPresent() ) {
            return Optional.of(userEntityMapper.entityToModel(entity.get()));
        }
        return  Optional.empty();
    }

    @Override
    public List<UserModel> findByRole(Long roleId) {
        return userEntityMapper.listEntityToModel(userRepository.findByRoleId(roleId));
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if( user.isPresent() ) {
            return Optional.of(userEntityMapper.entityToModel(user.get()));
        }
        return Optional.empty();

    }
    
}
