package com.tourgenius.accountservice.dto;

import com.tourgenius.accountservice.model.Role;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String email;
    private String password;
    private Role role;
}
