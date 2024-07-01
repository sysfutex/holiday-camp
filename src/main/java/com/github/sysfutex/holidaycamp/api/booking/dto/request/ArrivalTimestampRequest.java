package com.github.sysfutex.holidaycamp.api.booking.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalTimestampRequest {
    private LocalDateTime from;
    private LocalDateTime to;
}
