package com.github.sysfutex.holidaycamp.core.booking.service;

import com.github.sysfutex.holidaycamp.core.booking.exception.UserNotFoundException;
import com.github.sysfutex.holidaycamp.core.booking.model.BookingWithUserModel;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    List<BookingWithUserModel> getAllWithUser();

    List<BookingWithUserModel> getAllWithUserByUserPhoneNumber(String phoneNumber);

    List<BookingWithUserModel> getAllWithUserByArrivalDate(LocalDateTime from, LocalDateTime to);

    void create(String phoneNumber, Integer numberOfPeople, LocalDateTime arrivalTimestamp, LocalDateTime departureTimestamp) throws UserNotFoundException;

    void cancel(Long bookingId);

    void confirm(Long bookingId);

    void arrive(Long bookingId);

    void depart(Long bookingId);
}
