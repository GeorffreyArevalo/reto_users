package com.backend.core.users.application.handlers.role;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.core.users.application.dtos.roles.CreateRoleRequest;
import com.backend.core.users.application.dtos.roles.RoleResponse;
import com.backend.core.users.application.mappers.RoleMapper;
import com.backend.core.users.domain.api.RoleServicePort;
import com.backend.core.users.domain.models.RoleModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandlerImpl implements RoleHandler {

    private final RoleServicePort roleServicePort;
    private final RoleMapper roleMapper;

    @Override
    public void save(CreateRoleRequest role) {
        RoleModel roleModel = roleMapper.createRequestToModel(role);
        roleServicePort.saveRole(roleModel);
    }

    @Override
    public RoleResponse findByName(String name) {
        RoleModel role = roleServicePort.findByName(name);
        return roleMapper.modelToResponse(role);
    }
    
}
