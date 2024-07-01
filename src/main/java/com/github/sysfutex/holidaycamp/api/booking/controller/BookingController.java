package com.github.sysfutex.holidaycamp.api.booking.controller;

import com.github.sysfutex.holidaycamp.api.booking.dto.request.ArrivalTimestampRequest;
import com.github.sysfutex.holidaycamp.api.booking.dto.BookingWithUserDto;
import com.github.sysfutex.holidaycamp.api.booking.dto.request.BookingArrivalRequest;
import com.github.sysfutex.holidaycamp.api.booking.dto.request.BookingCancellationRequest;
import com.github.sysfutex.holidaycamp.api.booking.dto.request.BookingConfirmationRequest;
import com.github.sysfutex.holidaycamp.api.booking.dto.request.BookingDepartureRequest;
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
        addBookingsAttribute(model, bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUser()));
        addFormatterAttribute(model);
        addDisplayTypeAttributes(model);
        addActionsAttributes(model);

        return "bookings/all";
    }

    @PostMapping("/arrival")
    public String getBookingsByArrivalTimestamp(Model model, @ModelAttribute ArrivalTimestampRequest request) {
        addBookingsAttribute(model, bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUserByArrivalDate(request.getFrom(), request.getTo())));
        addFormatterAttribute(model);
        addDisplayTypeAttributes(model);
        addActionsAttributes(model);


        return "bookings/arrival";
    }

    @PostMapping("/phone")
    public String getBookingsByUserPhoneNumber(Model model, @ModelAttribute UserPhoneNumberRequest request) {
        addBookingsAttribute(model, bookingConverter.modelsWithUserToDtosWithUser(bookingService.getAllWithUserByUserPhoneNumber(request.getPhoneNumber())));
        addFormatterAttribute(model);
        addDisplayTypeAttributes(model);
        addActionsAttributes(model);

        return "bookings/phone";
    }

    private void addBookingsAttribute(Model model, List<BookingWithUserDto> dtos) {
        model.addAttribute("bookings", dtos);
    }

    private void addFormatterAttribute(Model model) {
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    private void addDisplayTypeAttributes(Model model) {
        model.addAttribute("arrivalRequest", new ArrivalTimestampRequest());
        model.addAttribute("phoneNumberRequest", new UserPhoneNumberRequest());
    }

    private void addActionsAttributes(Model model) {
        model.addAttribute("arrivalAction", new BookingArrivalRequest());
        model.addAttribute("cancellationAction", new BookingCancellationRequest());
        model.addAttribute("confirmationAction", new BookingConfirmationRequest());
        model.addAttribute("departureAction", new BookingDepartureRequest());
    }
}
