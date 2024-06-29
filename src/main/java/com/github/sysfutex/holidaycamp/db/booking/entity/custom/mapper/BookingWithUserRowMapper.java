package com.github.sysfutex.holidaycamp.db.booking.entity.custom.mapper;

import com.github.sysfutex.holidaycamp.db.booking.entity.custom.BookingWithUserEntity;
import com.github.sysfutex.holidaycamp.db.location.entity.custom.LocationWithoutUsersEntity;
import com.github.sysfutex.holidaycamp.db.user.entity.custom.UserWithLocationEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingWithUserRowMapper implements RowMapper<BookingWithUserEntity> {
    @Override
    public BookingWithUserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocationWithoutUsersEntity location = LocationWithoutUsersEntity.builder()
                .id(rs.getLong("locations_id"))
                .name(rs.getString("locations_name"))
                .build();

        UserWithLocationEntity user = UserWithLocationEntity.builder()
                .id(rs.getLong("users_id"))
                .name(rs.getString("users_name"))
                .phoneNumber(rs.getString("users_phone_number"))
                .location(location)
                .build();

        return BookingWithUserEntity.builder()
                .id(rs.getLong("bookings_id"))
                .createdAt(rs.getTimestamp("bookings_created_at").toLocalDateTime())
                .arrivalTimestamp(rs.getTimestamp("bookings_arrival_timestamp").toLocalDateTime())
                .isArrived(rs.getBoolean("bookings_is_arrived"))
                .arrivedAt(rs.getTimestamp("bookings_arrived_at").toLocalDateTime())
                .departureTimestamp(rs.getTimestamp("bookings_departure_timestamp").toLocalDateTime())
                .isDeparted(rs.getBoolean("bookings_is_departed"))
                .departedAt(rs.getTimestamp("bookings_departed_at").toLocalDateTime())
                .isConfirmed(rs.getBoolean("bookings_is_confirmed"))
                .confirmedAt(rs.getTimestamp("bookings_confirmed_at").toLocalDateTime())
                .isCanceled(rs.getBoolean("bookings_is_canceled"))
                .canceledAt(rs.getTimestamp("bookings_canceled_at").toLocalDateTime())
                .user(user)
                .build();
    }
}
