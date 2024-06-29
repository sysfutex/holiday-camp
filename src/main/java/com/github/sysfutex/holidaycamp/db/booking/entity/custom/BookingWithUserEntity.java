package com.github.sysfutex.holidaycamp.db.booking.entity.custom;

import com.github.sysfutex.holidaycamp.db.user.entity.custom.UserWithLocationEntity;

import java.time.LocalDateTime;

public record BookingWithUserEntity(
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

        UserWithLocationEntity user
) {
}