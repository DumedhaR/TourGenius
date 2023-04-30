package com.codemind.tourgenius.service;

import com.codemind.tourgenius.model.Booking;

import java.util.List;

public interface BookingService {

    Booking create(Booking booking);
    Booking findById(Long id);
    Booking update(Booking booking);
    List<Booking> findAll();
    Long delete(Booking booking);
}
