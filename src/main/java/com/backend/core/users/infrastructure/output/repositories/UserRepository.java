package com.backend.core.users.infrastructure.output.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.core.users.infrastructure.output.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findByRoleId(Long roleId);
    
}
