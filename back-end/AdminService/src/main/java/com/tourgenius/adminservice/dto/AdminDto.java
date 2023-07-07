package com.tourgenius.adminservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDto {
    private String email;
    private String password;
    private String name;
}
