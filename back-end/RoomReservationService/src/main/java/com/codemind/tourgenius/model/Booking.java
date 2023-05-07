package com.codemind.tourgenius.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Booking")
public class Booking {
    @Id
    private Long id;

    private String checkInDate;

    private String checkInTime;

    private String checkOutDate;

    private String checkOutTime;

    private Long userId;

    private Long roomId;

    
}
