package com.tourgenius.adminservice.dto;

import com.tourgenius.adminservice.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
