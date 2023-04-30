package com.codemind.tourgenius.dto.request;

import lombok.Data;

@Data
public class RoomCreateRequest {

    private  Long  id;

    private String type;

    private String size;

    private Double price;

    private String roomDesc;

}
