package com.payment.TourGeniusPayment.service;

import com.payment.TourGeniusPayment.dto.PaymentDto;
import com.payment.TourGeniusPayment.model.Payment;

import java.text.ParseException;
import java.util.List;

public interface PaymentService {
    String createPayment(PaymentDto paymentDto) throws ParseException;

    List<Payment> getUserPayment(String userId);

    List<Payment> getClientPayment(String clientId);
}
