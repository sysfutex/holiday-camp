package com.github.sysfutex.holidaycamp.api.user.dto;

import com.github.sysfutex.holidaycamp.api.location.dto.LocationWithoutUsersDto;
import lombok.Builder;

@Builder
public record UserWithLocationDto(
        Long id,

        String name,
        String phoneNumber,

        LocationWithoutUsersDto location
) {
}
