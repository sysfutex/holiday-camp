package com.github.sysfutex.holidaycamp.db.booking.entity;

import com.github.sysfutex.holidaycamp.db.user.entity.UserWithLocationEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookingWithUserEntity(
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

        UserWithLocationEntity user
) {
}
