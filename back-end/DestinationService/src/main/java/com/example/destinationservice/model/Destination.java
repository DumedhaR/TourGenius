package com.example.destinationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "destinations")
public class Destination {
    @Id
    private String id;
    private String name;
    private String image;
    private int rating;
    private String country;
    private String description;
}
