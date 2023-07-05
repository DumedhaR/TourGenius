package com.payment.TourGeniusPayment.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
public class PaymentDto {
    private String userId;
    private String bookingId;
    private double amount;
    private String date;
    private String clientId;
}
