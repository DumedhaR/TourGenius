package com.tourgeniuse.travelerservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TravelerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String country;
    private byte[] profilePicture;
}
