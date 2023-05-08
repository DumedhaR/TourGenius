package com.codemind.tourgenius.dto.response;


import lombok.Data;

@Data
public class BookingSearchResponse {

    private Long id;

    private String checkInDate;

    private String checkInTime;

    private String checkOutDate;

    private String checkOutTime;

    private Long userId;

    private Long roomId;
}
