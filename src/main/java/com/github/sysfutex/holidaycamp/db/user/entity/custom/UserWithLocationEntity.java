package com.github.sysfutex.holidaycamp.db.user.entity.custom;

import com.github.sysfutex.holidaycamp.db.location.entity.custom.LocationWithoutUsersEntity;
import lombok.Builder;

@Builder
public record UserWithLocationEntity(
        Long id,

        String name,
        String phoneNumber,

        LocationWithoutUsersEntity location
) {
}
