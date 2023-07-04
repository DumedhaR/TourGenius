package com.tourgenius.accountservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
public class TravelerDto {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String dateOfBirth;
    @NonNull
    private String country;
    @Nullable
    private byte[] profilePicture;
}
