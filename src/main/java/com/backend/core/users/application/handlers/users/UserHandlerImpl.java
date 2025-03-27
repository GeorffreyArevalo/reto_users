package com.backend.core.users.application.handlers.users;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.core.users.application.dtos.users.CreateUserRequest;
import com.backend.core.users.application.dtos.users.UserResponse;
import com.backend.core.users.application.mappers.UserMapper;
import com.backend.core.users.domain.api.RoleServicePort;
import com.backend.core.users.domain.api.UserServicePort;
import com.backend.core.users.domain.models.RoleModel;
import com.backend.core.users.domain.models.UserModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandlerImpl implements UserHandler{

    private final UserServicePort userServicePort;
    private final RoleServicePort roleServicePort;
    private final UserMapper userMapper;


    @Override
    public void saveUser(CreateUserRequest userRequest) {
        userRequest.validate();
        RoleModel role = roleServicePort.findByName(userRequest.getRoleName());
        UserModel user = userMapper.createRequestToModel(userRequest);
        user.setRole(role);
        userServicePort.saveUser(user);
    }


    @Override
    public UserResponse findById(Long id) {
        return userMapper.modelToResponse(userServicePort.findById(id));
    }
    
}
