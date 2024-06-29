package com.github.sysfutex.holidaycamp.db.location.entity.custom.mapper;

import com.github.sysfutex.holidaycamp.db.location.entity.custom.LocationWithoutUsersEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationWithoutUsersRowMapper implements RowMapper<LocationWithoutUsersEntity> {
    @Override
    public LocationWithoutUsersEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return LocationWithoutUsersEntity.builder()
                .id(rs.getLong("locations_id"))
                .name(rs.getString("locations_name"))
                .build();
    }
}
