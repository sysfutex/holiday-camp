package com.github.sysfutex.holidaycamp.core.booking.service.impl;

import com.github.sysfutex.holidaycamp.core.booking.model.BookingWithUserModel;
import com.github.sysfutex.holidaycamp.core.booking.model.converter.BookingConverter;
import com.github.sysfutex.holidaycamp.core.booking.service.BookingService;
import com.github.sysfutex.holidaycamp.db.booking.repo.BookingRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingsServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;
    private final BookingConverter bookingConverter;

    @Override
    public List<BookingWithUserModel> getAllWithUser() {
        return bookingConverter.entitiesWithUserToModelsWithUser(bookingRepo.findAllWithUser());
    }

    @Override
    public List<BookingWithUserModel> getAllWithUserByUserPhoneNumber(String phoneNumber) {
        return bookingConverter.entitiesWithUserToModelsWithUser(bookingRepo.findAllWithUserByUserPhoneNumber(phoneNumber));
    }

    @Override
    public List<BookingWithUserModel> getAllWithUserByArrivalDate(LocalDateTime from, LocalDateTime to) {
        return bookingConverter.entitiesWithUserToModelsWithUser(bookingRepo.findAllWithUserByArrivalDate(from, to));
    }
}
