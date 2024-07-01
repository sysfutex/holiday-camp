package com.github.sysfutex.holidaycamp.common.user.converter;

import com.github.sysfutex.holidaycamp.core.user.model.UserDetailWithRolesModel;
import com.github.sysfutex.holidaycamp.db.user.entity.UserDetailWithRolesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleConverter.class}
)
public interface UserDetailConverter {
    UserDetailWithRolesModel entityWithRolesToModelWithRoles(UserDetailWithRolesEntity entity);

    List<UserDetailWithRolesModel> entitiesWithRolesToModelsWithRoles(List<UserDetailWithRolesEntity> entities);
}
