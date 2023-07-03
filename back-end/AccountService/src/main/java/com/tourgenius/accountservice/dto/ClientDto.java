package com.tourgenius.accountservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDto {

    private String organizationName;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String password;
    private byte[] profilePicture;
}
