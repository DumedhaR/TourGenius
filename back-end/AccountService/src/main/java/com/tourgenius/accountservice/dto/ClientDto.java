package com.tourgenius.accountservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
public class ClientDto {
    private String organizationName;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private byte[] profilePicture;
}
