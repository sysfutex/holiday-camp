package com.github.sysfutex.holidaycamp.core.user.model;

import com.github.sysfutex.holidaycamp.core.location.model.LocationWithoutUsersModel;
import lombok.Builder;

@Builder
public record UserWithLocationModel(
        Long id,

        String name,
        String phoneNumber,

        LocationWithoutUsersModel location
) {
}
