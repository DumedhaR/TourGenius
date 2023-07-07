package com.codemind.tourgenius.service;

import com.codemind.tourgenius.dto.request.BookingRequest;
import com.codemind.tourgenius.model.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> findAllBookings();
    List<Booking> findAllBookingsByUserId(String id);
    List<Booking> findAllBookingsByClientId(String id);
    String create(BookingRequest request);
    String delete(String id);
}
