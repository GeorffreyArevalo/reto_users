package com.backend.core.users.application.handlers.auth;

import org.springframework.stereotype.Service;

import com.backend.core.users.application.dtos.users.LoginRequest;
import com.backend.core.users.application.dtos.users.LoginResponse;
import com.backend.core.users.application.mappers.UserMapper;
import com.backend.core.users.domain.api.UserServicePort;
import com.backend.core.users.domain.models.UserModel;
import com.backend.core.users.domain.spi.TokenAuthenticatePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements AuthHandler{
    
    private final UserServicePort userServicePort;
    private final UserMapper userMapper;
    private final TokenAuthenticatePort tokenAuthenticatePort;

    public LoginResponse login(LoginRequest userLogin) {
        UserModel user = userServicePort.login( userLogin.getEmail(), userLogin.getPassword() );
        String token = tokenAuthenticatePort.createToken(user);
        return userMapper.userToLoginResponse(user, token);
    }

    @Override
    public LoginResponse validateToken(String token) {
        String email = tokenAuthenticatePort.validateToken(token);
        UserModel user = userServicePort.findByEmail(email);
        return userMapper.userToLoginResponse(user, token);
    }

}
