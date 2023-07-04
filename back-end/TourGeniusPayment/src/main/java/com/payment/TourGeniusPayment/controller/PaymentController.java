package com.payment.TourGeniusPayment.controller;

import com.payment.TourGeniusPayment.dto.PaymentDto;
import com.payment.TourGeniusPayment.model.Payment;
import com.payment.TourGeniusPayment.repository.PaymentRepository;
import com.payment.TourGeniusPayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/Payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping(value = "/create")
    public String createPayment(@RequestBody PaymentDto paymentDto) throws ParseException {
        return paymentService.createPayment(paymentDto);
    }

    @GetMapping(value = "/getUser/{userId}")
    public List<Payment> getUserPayment(@PathVariable String userId) {
        return paymentService.getUserPayment(userId);
    }
    @GetMapping(value = "/getClient/{clientId}")
    public List<Payment> getClientPayment(@PathVariable String clientId) {
        return paymentService.getClientPayment(clientId);
    }

}
