package com.codemind.tourgenius.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "Rooms")
public class Room {
    @Id
    private String id;
    private String packageId;
    private String clientId;
}
