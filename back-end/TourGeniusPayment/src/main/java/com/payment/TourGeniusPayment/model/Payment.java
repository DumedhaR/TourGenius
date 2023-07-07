package com.payment.TourGeniusPayment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Payment")
public class Payment {
    @Id
    private String id;
    private String userId;
    private String bookingId;
    private double amount;
    private Date date;
    private String clientId;
}
