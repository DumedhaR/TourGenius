package com.payment.TourGeniusPayment.service;

import com.payment.TourGeniusPayment.dto.PaymentDto;
import com.payment.TourGeniusPayment.model.Payment;
import com.payment.TourGeniusPayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    private Date stringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.parse(date);
    }
    @Override
    public String createPayment(PaymentDto paymentDto) throws ParseException {
        Payment payment = new Payment();
        payment.setUserId(paymentDto.getUserId());
        payment.setDate(stringToDate(paymentDto.getDate()));
        payment.setAmount(paymentDto.getAmount());
        payment.setClientId(paymentDto.getClientId());
        payment.setBookingId(paymentDto.getBookingId());
        paymentRepository.save(payment);
        return "created";
    }

    @Override
    public List<Payment> getUserPayment(String userId) {
        return paymentRepository.findAllByUserId(userId).orElseThrow();
    }

    @Override
    public List<Payment> getClientPayment(String clientId) {
        return paymentRepository.findAllByClientId(clientId).orElseThrow();
    }

}
