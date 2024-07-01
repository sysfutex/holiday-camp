package com.github.sysfutex.holidaycamp.api.location.dto;

import lombok.Builder;

@Builder
public record LocationWithoutUsersDto(
        Long id,

        String name
) {
}
