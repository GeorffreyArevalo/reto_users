package com.backend.core.users.infrastructure.output.adapters;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.backend.core.users.domain.models.RoleModel;
import com.backend.core.users.domain.spi.RolePersistencePort;
import com.backend.core.users.infrastructure.output.entities.RoleEntity;
import com.backend.core.users.infrastructure.output.mappers.RoleEntityMapper;
import com.backend.core.users.infrastructure.output.repositories.RoleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements RolePersistencePort {

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public Optional<RoleModel> saveRole(RoleModel role) {
        RoleEntity entity = roleEntityMapper.modelToEntity(role);
        RoleEntity entitySaved = roleRepository.save(entity);
        return Optional.of(roleEntityMapper.entityToModel(entitySaved));
    }

    @Override
    public Optional<RoleModel> findByName(String name) {
        Optional<RoleEntity> entity = roleRepository.findByName(name);
        if( entity.isPresent() ) {
            return Optional.of( roleEntityMapper.entityToModel(entity.get()) );
        }
        return Optional.empty();
    }
    
}
