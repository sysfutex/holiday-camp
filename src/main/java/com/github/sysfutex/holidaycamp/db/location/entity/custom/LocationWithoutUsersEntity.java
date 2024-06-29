package com.github.sysfutex.holidaycamp.db.location.entity.custom;

import lombok.Builder;

@Builder
public record LocationWithoutUsersEntity(
        Long id,

        String name
) {
}
