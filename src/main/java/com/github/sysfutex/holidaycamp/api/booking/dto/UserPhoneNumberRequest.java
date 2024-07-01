package com.github.sysfutex.holidaycamp.api.booking.dto;

import lombok.Builder;

@Builder
public record UserPhoneNumberRequest(
        String phoneNumber
) {
}
