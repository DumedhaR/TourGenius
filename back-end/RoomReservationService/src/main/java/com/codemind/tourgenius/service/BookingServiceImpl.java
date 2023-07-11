package com.codemind.tourgenius.service;

import com.codemind.tourgenius.dto.request.BookingRequest;
import com.codemind.tourgenius.model.Booking;
import com.codemind.tourgenius.repository.BookingRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ClientPackageService clientPackageService;

    @Transactional
    @Override
    public String create(@NotNull BookingRequest request) {
        Booking booking = new Booking();
        try {
            booking.setRooms(clientPackageService.getAvailableRoomsByClientPackage(
                    request.getClientId(),
                    request.getPackageId(),
                    request.getCheckInDate(),
                    request.getCheckOutDate()).subList(0, request.getTotalRooms()));
        }catch (IndexOutOfBoundsException e){
            System.out.println("rooms are not available");
            return "Booking failed, rooms are not available";
        }
        booking.setCheckInDate(request.getCheckInDate());
        booking.setCheckOutDate(request.getCheckOutDate());
        booking.setClientId(request.getClientId());
        booking.setUserId(request.getUserId());
        booking.setPackageId(request.getPackageId());
        booking.setPayment(request.getPayment());
        booking.setGuestEmail(request.getGuestEmail());
        booking.setGuestFirstName(request.getGuestFirstName());
        booking.setGuestFirstName(request.getGuestFirstName());
        booking.setTotalGuest(request.getTotalGuest());
        booking.setOpen(true);
        bookingRepository.save(booking);
        return "created";
    }

    @Override
    public String delete(String id) {
        bookingRepository.findById(id).orElseThrow();
        bookingRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findAllBookingsByUserId(String id) {
        return bookingRepository.getBookingsByUserId(id);
    }

    @Override
    public List<Booking> findAllBookingsByClientId(String id) {
        return bookingRepository.getBookingsByClientId(id);
    }

}
