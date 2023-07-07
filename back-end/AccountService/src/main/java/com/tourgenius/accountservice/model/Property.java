package com.tourgenius.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ClientProperty")
public class Property {
    @Id
    private String propertyId;
    @NonNull
    private String propertyName;
    @NonNull
    private String description;
    @NonNull
    private byte [] coverImage;
    private List<byte []> media;
    @NonNull
    private String clientId;
}
