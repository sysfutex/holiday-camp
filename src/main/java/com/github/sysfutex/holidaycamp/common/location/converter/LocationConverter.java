package com.github.sysfutex.holidaycamp.common.location.converter;

import com.github.sysfutex.holidaycamp.core.location.model.LocationWithoutUsersModel;
import com.github.sysfutex.holidaycamp.db.location.entity.LocationWithoutUsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationConverter {
    LocationWithoutUsersModel entityWithoutUsersToModelWithoutUsers(LocationWithoutUsersEntity entity);
    List<LocationWithoutUsersModel> entitiesWithoutUsersToModelsWithoutUsers(List<LocationWithoutUsersEntity> entities);
}
