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

    @GetMapping("/search")
    public List<BookingSearchResponse> search() {
        List<BookingSearchResponse> bookingSearchResponseList =  new ArrayList<>();
        List<Booking> bookings = bookingService.findAllBookings();
        return getBookingSearchResponses(bookingSearchResponseList, bookings);
    }

    @GetMapping ("/traveller/{id}")
    public List<BookingSearchResponse> getBookingByUserId(@PathVariable String id) {
        List<BookingSearchResponse> bookingSearchResponseList =  new ArrayList<>();
        List<Booking> bookings = bookingService.findAllBookingsByUserId(id);
        return getBookingSearchResponses(bookingSearchResponseList, bookings);
    }

    @GetMapping ("/client/{id}")
    public List<BookingSearchResponse> getBookingByClientId(@PathVariable String id) {
        List<BookingSearchResponse> bookingSearchResponseList =  new ArrayList<>();
        List<Booking> bookings = bookingService.findAllBookingsByClientId(id);
        return getBookingSearchResponses(bookingSearchResponseList, bookings);
    }

    private List<BookingSearchResponse> getBookingSearchResponses(List<BookingSearchResponse> bookingSearchResponseList, List<Booking> bookings) {
        return bookingSearchResponseList;
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteBooking(@PathVariable String id) {
        return bookingService.delete(id);
    }
}
