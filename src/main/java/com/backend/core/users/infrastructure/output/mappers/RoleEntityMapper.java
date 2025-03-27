package com.backend.core.users.infrastructure.output.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.backend.core.users.domain.models.RoleModel;
import com.backend.core.users.infrastructure.output.entities.RoleEntity;


@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RoleEntityMapper {
    
    RoleModel entityToModel( RoleEntity entity );

    RoleEntity modelToEntity( RoleModel model );

    List<RoleModel> listEntityToModel( List<RoleEntity> entities );

}
