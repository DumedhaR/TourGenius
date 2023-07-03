package com.codemind.tourgenius.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "ClientPackages")
public class ClientPackage {
    @Id
    private String id;
    private String clientId;
    private String packageName;
    private String size;
    private int maxGuest;
    private Double price;
    private String roomDesc;
    private int totalRooms;
    private List<String> features;
    private byte[] coverImage;
}
