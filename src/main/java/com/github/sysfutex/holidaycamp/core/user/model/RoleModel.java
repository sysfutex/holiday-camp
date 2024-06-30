package com.github.sysfutex.holidaycamp.core.user.model;

import lombok.Builder;

@Builder
public record RoleModel(
        Long id,

        String name,
        String description
) {
}
