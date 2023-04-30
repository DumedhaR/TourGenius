package com.codemind.tourgenius.dto.request;

import lombok.Data;

@Data
public class BookingUpdateRequest {

    private Long id;

    private String checkInDate;

    private String checkInTime;

    private String checkOutDate;

    private String checkOutTime;

    private Long userId;
}
