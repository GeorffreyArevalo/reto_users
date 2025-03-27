package com.backend.core.users.infrastructure.output.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.core.users.infrastructure.output.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    
    Optional<RoleEntity> findByName(String name);

}
