package com.tourgenius.clientservice.dto;

import com.tourgenius.clientservice.model.MediaUtil;
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
