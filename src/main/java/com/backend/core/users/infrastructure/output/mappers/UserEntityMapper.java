package com.backend.core.users.infrastructure.output.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.backend.core.users.domain.models.UserModel;
import com.backend.core.users.infrastructure.output.entities.UserEntity;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {RoleEntityMapper.class}
)
public interface UserEntityMapper {

    UserModel entityToModel( UserEntity entity );

    UserEntity modelToEntity( UserModel model );

    List<UserModel> listEntityToModel( List<UserEntity> entities );

}
