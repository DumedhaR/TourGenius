package com.codemind.tourgenius.dto.request;

import lombok.Data;

@Data
public class RoomUpdateRequest {

    private String type;

    private String size;

    private Double price;

    private String roomDesc;

}
