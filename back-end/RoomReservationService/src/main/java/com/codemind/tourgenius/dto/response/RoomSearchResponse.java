package com.codemind.tourgenius.dto.response;

import lombok.Data;

@Data
public class RoomSearchResponse {

    private  Long  id;

    private String type;

    private String size;

    private Double price;

    private String roomDesc;

    private Boolean availability;
}
