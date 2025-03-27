package com.backend.core.users.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.backend.core.users.application.dtos.users.CreateUserRequest;
import com.backend.core.users.application.dtos.users.UserResponse;
import com.backend.core.users.domain.models.UserModel;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
    

    UserModel createRequestToModel( CreateUserRequest createUserRequest );

    UserResponse modelToResponse( UserModel userModel );

}
