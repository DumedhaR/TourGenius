package com.codemind.tourgenius.dto;

import com.codemind.tourgenius.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
public class BookingResultDto {
        private String _id;
        private List<Object> bookings;
}
