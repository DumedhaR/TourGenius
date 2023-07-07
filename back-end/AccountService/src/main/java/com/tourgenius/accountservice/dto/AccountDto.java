package com.tourgenius.accountservice.dto;

import com.tourgenius.accountservice.model.Role;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountDto {
    @NonNull
    private String email;
    @NonNull
    private String password;
    @Nullable
    private Role role;
}
