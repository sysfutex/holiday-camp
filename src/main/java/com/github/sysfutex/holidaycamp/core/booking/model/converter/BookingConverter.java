package com.github.sysfutex.holidaycamp.core.booking.model.converter;

import com.github.sysfutex.holidaycamp.core.booking.model.BookingWithUserModel;
import com.github.sysfutex.holidaycamp.core.user.model.converter.UserConverter;
import com.github.sysfutex.holidaycamp.db.booking.entity.BookingWithUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserConverter.class}
)
public interface BookingConverter {
    BookingWithUserModel entityWithUserToModelWithUser(BookingWithUserEntity entity);
    List<BookingWithUserModel> entitiesWithUserToModelsWithUser(List<BookingWithUserEntity> entities);
}
