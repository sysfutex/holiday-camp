package com.github.sysfutex.holidaycamp.api.booking.controller;

import com.github.sysfutex.holidaycamp.api.booking.dto.request.ArrivalTimestampRequest;
import com.github.sysfutex.holidaycamp.api.booking.dto.BookingWithUserDto;
import com.github.sysfutex.holidaycamp.api.booking.dto.request.UserPhoneNumberRequest;
import com.github.sysfutex.holidaycamp.common.booking.converter.BookingConverter;
import com.github.sysfutex.holidaycamp.core.booking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final BookingConverter bookingConverter;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAllBookings(Model model) {
        List<BookingWithUserDto> dtos = bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUser());
        model.addAttribute("bookings", dtos);

        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        model.addAttribute("arrivalRequest", new ArrivalTimestampRequest());
        model.addAttribute("phoneNumberRequest", new UserPhoneNumberRequest());

        return "bookings/all";
    }

    @PostMapping("/arrival")
    public String getBookingsByArrivalTimestamp(Model model, @ModelAttribute ArrivalTimestampRequest request) {
        List<BookingWithUserDto> dtos = bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUserByArrivalDate(request.getFrom(), request.getTo()));
        model.addAttribute("bookings", dtos);

        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        model.addAttribute("arrivalRequest", new ArrivalTimestampRequest());
        model.addAttribute("phoneNumberRequest", new UserPhoneNumberRequest());

        return "bookings/arrival";
    }

    @PostMapping("/phone")
    public String getBookingsByUserPhoneNumber(Model model, @ModelAttribute UserPhoneNumberRequest request) {
        List<BookingWithUserDto> dtos = bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUserByUserPhoneNumber(request.getPhoneNumber()));
        model.addAttribute("bookings", dtos);

        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));

        model.addAttribute("arrivalRequest", new ArrivalTimestampRequest());
        model.addAttribute("phoneNumberRequest", new UserPhoneNumberRequest());

        return "bookings/phone";
    }
}
