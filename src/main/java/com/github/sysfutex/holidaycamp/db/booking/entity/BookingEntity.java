package com.github.sysfutex.holidaycamp.db.booking.entity;

import com.github.sysfutex.holidaycamp.db.user.entity.UserEntity;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Builder
@Table("bookings")
public record BookingEntity(
        @Id @Column("id") Long id,

        @Column("user_id") AggregateReference<UserEntity, Long> userRef,

        @Column("number_of_people") Integer numberOfPeople,

        @Column("created_at") LocalDateTime createdAt,

        @Column("arrival_timestamp") LocalDateTime arrivalTimestamp,
        @Column("is_arrived") Boolean isArrived,
        @Column("arrived_at") LocalDateTime arrivedAt,

        @Column("departure_timestamp") LocalDateTime departureTimestamp,
        @Column("is_departed") Boolean isDeparted,
        @Column("departed_at") LocalDateTime departedAt,

        @Column("is_confirmed") Boolean isConfirmed,
        @Column("confirmed_at") LocalDateTime confirmedAt,

        @Column("is_canceled") Boolean isCanceled,
        @Column("canceled_at") LocalDateTime canceledAt
) {
}
