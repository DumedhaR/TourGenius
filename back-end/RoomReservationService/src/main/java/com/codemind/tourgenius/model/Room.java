package com.codemind.tourgenius.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Room")
public class Room {
    @Id
    private Long id;

    private String type;

    private String size;

    private Double price;

    private String roomDesc;

    private Boolean availability;

}
