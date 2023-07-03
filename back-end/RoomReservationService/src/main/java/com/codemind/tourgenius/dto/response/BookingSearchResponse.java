package com.codemind.tourgenius.dto.response;


import lombok.Data;

import java.util.List;

@Data
public class BookingSearchResponse {
    private String checkInDate;
    private String checkOutDate;
    private Long userId;
    private List<Long> roomId;
}
