package com.codemind.tourgenius.controller;

import com.codemind.tourgenius.dto.request.BookingRequest;
import com.codemind.tourgenius.dto.response.BookingSearchResponse;
import com.codemind.tourgenius.model.Booking;
import com.codemind.tourgenius.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/reservation")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public String createBooking(@RequestBody BookingRequest request){
        return bookingService.create(request);
    }

    @GetMapping ("/traveller/{id}")
    public List<Booking> getBookingByUserId(@PathVariable String id) {
        return bookingService.findAllBookingsByUserId(id);
    }

    @GetMapping ("/client/{id}")
    public List<Booking> getBookingByClientId(@PathVariable String id) {
        return bookingService.findAllBookingsByClientId(id);
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteBooking(@PathVariable String id) {
        return bookingService.delete(id);
    }
}
