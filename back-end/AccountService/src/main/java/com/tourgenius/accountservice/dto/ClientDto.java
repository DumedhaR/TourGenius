package com.tourgenius.accountservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
public class ClientDto {
    @NonNull
    private String organizationName;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String contactNumber;
    @NonNull
    private String email;
    @Nullable
    private byte[] profilePicture;
}
