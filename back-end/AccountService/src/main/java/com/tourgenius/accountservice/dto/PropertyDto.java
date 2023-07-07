package com.tourgenius.accountservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
@Data
@NoArgsConstructor
public class PropertyDto {
    private String propertyName;
    private String description;
    private byte [] coverImage;
    private List<byte []> media;
    private String clientId;
}
