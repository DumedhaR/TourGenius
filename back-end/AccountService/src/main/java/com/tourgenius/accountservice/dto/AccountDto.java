package com.tourgenius.accountservice.dto;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String email;
    private String password;
    private String role;
}
