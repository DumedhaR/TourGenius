package com.tourgenius.travellerservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TravellerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
    private String country;
    private byte[] profilePicture;
}
