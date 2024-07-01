package com.github.sysfutex.holidaycamp.api.booking.controller;

import com.github.sysfutex.holidaycamp.api.booking.dto.ArrivalTimestampRequest;
import com.github.sysfutex.holidaycamp.api.booking.dto.BookingWithUserDto;
import com.github.sysfutex.holidaycamp.api.booking.dto.UserPhoneNumberRequest;
import com.github.sysfutex.holidaycamp.common.booking.converter.BookingConverter;
import com.github.sysfutex.holidaycamp.core.booking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final BookingConverter bookingConverter;

    @GetMapping("/all")
    public String getAllBookings(Model model) {
        List<BookingWithUserDto> dtos = bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUser());
        model.addAttribute("bookings", dtos);

        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        return "bookings/all";
    }

    @GetMapping("/arrival")
    public String getBookingsByArrivalTimestamp(Model model, @ModelAttribute ArrivalTimestampRequest request) {
        List<BookingWithUserDto> dtos = bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUserByArrivalDate(request.from(), request.to()));
        model.addAttribute("bookings", dtos);

        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        return "bookings/arrival";
    }

    @GetMapping("/phone")
    public String getBookingsByUserPhoneNumber(Model model, @ModelAttribute UserPhoneNumberRequest request) {
        List<BookingWithUserDto> dtos = bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUserByUserPhoneNumber(request.phoneNumber()));
        model.addAttribute("bookings", dtos);

        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        return "bookings/phone";
    }
}
