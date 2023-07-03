package com.tourgenius.accountservice.dto;

import com.tourgenius.accountservice.model.MediaUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class PropertyDto {
    private String propertyName;
    private String description;
    private String type;
    private List<MediaUtil> media;
    private String clientId;
}
