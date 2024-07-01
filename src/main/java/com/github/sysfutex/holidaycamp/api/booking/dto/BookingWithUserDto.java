package com.github.sysfutex.holidaycamp.api.booking.dto;

import com.github.sysfutex.holidaycamp.api.user.dto.UserWithLocationDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookingWithUserDto(
        Long id,

        Integer numberOfPeople,

        LocalDateTime createdAt,

        LocalDateTime arrivalTimestamp,
        Boolean isArrived,
        LocalDateTime arrivedAt,

        LocalDateTime departureTimestamp,
        Boolean isDeparted,
        LocalDateTime departedAt,

        Boolean isConfirmed,
        LocalDateTime confirmedAt,

        Boolean isCanceled,
        LocalDateTime canceledAt,

        UserWithLocationDto user
) {
}
