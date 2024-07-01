package com.github.sysfutex.holidaycamp.api.booking.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ArrivalTimestampRequest(
        LocalDateTime from,
        LocalDateTime to
) {
}
