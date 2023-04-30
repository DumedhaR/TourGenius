package com.codemind.tourgenius.service.impl;

import com.codemind.tourgenius.model.Booking;
import com.codemind.tourgenius.repository.BookingRepository;
import com.codemind.tourgenius.repository.RoomRepository;
import com.codemind.tourgenius.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking findById(Long id) {
       return  bookingRepository.findById(id).get();

    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Long delete(Booking booking) {
        bookingRepository.delete(booking);
        return booking.getId();
    }
}
