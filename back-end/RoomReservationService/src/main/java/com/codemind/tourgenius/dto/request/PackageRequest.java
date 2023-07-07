package com.codemind.tourgenius.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class PackageRequest {
    private String clientId;
    private String packageName;
    private String size;
    private int maxGuest;
    private Double price;
    private String roomDesc;
    private int totalRooms;
    private List<String> features;
    private byte[] coverImage;
}
