package com.tourgenius.accountservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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
