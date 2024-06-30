package com.github.sysfutex.holidaycamp.core.booking.service;

import com.github.sysfutex.holidaycamp.core.booking.model.BookingWithUserModel;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    List<BookingWithUserModel> getAllWithUser();

    List<BookingWithUserModel> getAllWithUserByUserPhoneNumber(String phoneNumber);

    List<BookingWithUserModel> getAllWithUserByArrivalDate(LocalDateTime from, LocalDateTime to);
}
