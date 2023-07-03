package com.codemind.tourgenius.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Booking")
public class Booking {
    @Id
    private String id;
    private Date checkInDate;
    private Date checkOutDate;
    private String userId;
    private String clientId;
    private String packageId;
    private List<String> rooms;
    private boolean isOpen;
}
