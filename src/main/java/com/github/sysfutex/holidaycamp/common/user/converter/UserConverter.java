package com.github.sysfutex.holidaycamp.common.user.converter;

import com.github.sysfutex.holidaycamp.api.user.dto.UserWithLocationDto;
import com.github.sysfutex.holidaycamp.common.location.converter.LocationConverter;
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

    UserWithLocationDto modelWithLocationToDtoWithLocation(UserWithLocationModel model);

    List<UserWithLocationDto> modelsWithLocationToDtosWithLocation(List<UserWithLocationModel> models);
}
