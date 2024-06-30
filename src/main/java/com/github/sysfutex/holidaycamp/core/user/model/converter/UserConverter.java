package com.github.sysfutex.holidaycamp.core.user.model.converter;

import com.github.sysfutex.holidaycamp.core.location.model.converter.LocationConverter;
import com.github.sysfutex.holidaycamp.core.user.model.UserWithLocationModel;
import com.github.sysfutex.holidaycamp.db.user.entity.UserWithLocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {LocationConverter.class}
)
public interface UserConverter {
    UserWithLocationModel entityWithLocationToModelWithLocation(UserWithLocationEntity entity);
    List<UserWithLocationModel> entitiesWithLocationToModelsWithLocation(List<UserWithLocationEntity> entities);
}
