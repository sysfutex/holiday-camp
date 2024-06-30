package com.github.sysfutex.holidaycamp.db.location.entity;

import lombok.Builder;

@Builder
public record LocationWithoutUsersEntity(
        Long id,

        String name
) {
}
