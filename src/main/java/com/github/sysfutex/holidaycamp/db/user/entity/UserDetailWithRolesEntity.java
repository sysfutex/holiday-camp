package com.github.sysfutex.holidaycamp.db.user.entity;

import lombok.Builder;

import java.util.List;

@Builder
public record UserDetailWithRolesEntity(
        Long userId,

        String username,
        String passwordHash,

        Boolean isAccountNonExpired,
        Boolean isAccountNonLocked,
        Boolean isCredentialsNonExpired,
        Boolean isEnabled,

        List<RoleEntity> roles
) {
}
