package com.github.sysfutex.holidaycamp.core.location.model;

import lombok.Builder;

@Builder
public record LocationWithoutUsersModel(
        Long id,

        String name
) {
}
