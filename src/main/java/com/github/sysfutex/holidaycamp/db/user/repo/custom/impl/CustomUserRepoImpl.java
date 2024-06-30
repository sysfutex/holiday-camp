package com.github.sysfutex.holidaycamp.db.user.repo.custom.impl;

import com.github.sysfutex.holidaycamp.db.user.repo.custom.CustomUserRepo;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.Map;

@AllArgsConstructor
public class CustomUserRepoImpl implements CustomUserRepo {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Long createUser(
            @NotNull String name,
            @NotNull String phoneNumber,
            @NotNull String locationName,
            @NotNull String passwordHash,
            @NotNull String[] roleNames
    ) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("create_user");

        SqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("new_user_name", name)
                .addValue("new_user_phone_number", phoneNumber)
                .addValue("new_user_location_name", locationName)
                .addValue("new_user_password_hash", passwordHash)
                .addValue("new_user_role_names", roleNames);

        Map<String, Object> outParams = simpleJdbcCall.execute(inParams);

        return (Long) outParams.get("new_user_id");
    }
}
