package com.backend.core.users.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backend.core.users.domain.api.RoleServicePort;
import com.backend.core.users.domain.api.UserServicePort;
import com.backend.core.users.domain.spi.RolePersistencePort;
import com.backend.core.users.domain.spi.UserPersistencePort;
import com.backend.core.users.domain.usecases.RoleUseCases;
import com.backend.core.users.domain.usecases.UserUseCases;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CreateBeansConfiguration {
    
    private final UserPersistencePort userPersistencePort;
    private final RolePersistencePort rolePersistencePort;

    @Bean
    UserServicePort userServicePort() {
        return new UserUseCases(userPersistencePort, rolePersistencePort);
    }

    @Bean
    RoleServicePort roleServicePort() {
        return new RoleUseCases(rolePersistencePort);
    }


}
