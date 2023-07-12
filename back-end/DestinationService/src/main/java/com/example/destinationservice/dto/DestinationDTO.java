package com.example.destinationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDTO {
    private String id;
    private String name;
    private String image;
    private int rating;
    private String country;
    private String description;
}
