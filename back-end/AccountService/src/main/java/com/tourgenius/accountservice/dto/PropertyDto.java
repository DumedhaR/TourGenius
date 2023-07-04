package com.tourgenius.accountservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
@Data
@NoArgsConstructor
public class PropertyDto {
    @NonNull
    private String propertyName;
    @NonNull
    private String description;
    @Nullable
    private String type;
    @Nullable
    private List<MediaUtil> media;
    @NonNull
    private String clientId;
}
