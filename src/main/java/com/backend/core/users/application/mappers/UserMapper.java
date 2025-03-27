package com.backend.core.users.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.backend.core.users.application.dtos.users.CreateUserRequest;
import com.backend.core.users.application.dtos.users.UserResponse;
import com.backend.core.users.domain.models.UserModel;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    uses = {RoleMapper.class}
)
public interface UserMapper {
    

    UserModel createRequestToModel( CreateUserRequest createUserRequest );

    @Mappings(
        @Mapping( target = "roleName", source = "userModel.role.name" )
    )
    UserResponse modelToResponse( UserModel userModel );

}
