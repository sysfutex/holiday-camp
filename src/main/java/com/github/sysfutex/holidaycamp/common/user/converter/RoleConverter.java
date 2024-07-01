package com.github.sysfutex.holidaycamp.common.user.converter;

import com.github.sysfutex.holidaycamp.core.user.model.RoleModel;
import com.github.sysfutex.holidaycamp.db.user.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleConverter {
    RoleModel entityToModel(RoleEntity entity);

    List<RoleModel> entitiesToModels(List<RoleEntity> entities);
}
