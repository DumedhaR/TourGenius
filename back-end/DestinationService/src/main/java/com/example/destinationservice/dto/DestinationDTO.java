package com.example.destinationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDTO {
    private String name;
    private MultipartFile image;
    private int rating;
    private String country;
    private String description;
}
