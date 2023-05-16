package com.tourgenius.travelerservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto {

    private String email;
    private String password;
    private String role;
}