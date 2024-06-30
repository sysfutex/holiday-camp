package com.github.sysfutex.holidaycamp.core.booking.model;

import com.github.sysfutex.holidaycamp.core.user.model.UserWithLocationModel;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookingWithUserModel(
        Long id,

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

        UserWithLocationModel user
) {
}
