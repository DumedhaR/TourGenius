package com.tourgenius.clientservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ClientProperty")
public class Property {
    @Id
    private String propertyId;
    private String propertyName;
    private String description;
    private String type;
    private List<MediaUtil> media;
    private String clientId;
}
