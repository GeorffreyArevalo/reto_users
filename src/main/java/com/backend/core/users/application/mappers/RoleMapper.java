package com.backend.core.users.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.backend.core.users.application.dtos.roles.CreateRoleRequest;
import com.backend.core.users.application.dtos.roles.RoleResponse;
import com.backend.core.users.domain.models.RoleModel;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RoleMapper {
    
    RoleModel createRequestToModel( CreateRoleRequest createRoleRequest );

    RoleResponse modelToResponse( RoleModel roleModel );

    RoleModel responseToModel( RoleResponse rokResponse );


}
