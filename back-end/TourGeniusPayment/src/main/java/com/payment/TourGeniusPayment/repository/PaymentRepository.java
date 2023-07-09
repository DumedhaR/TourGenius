package com.payment.TourGeniusPayment.repository;

import com.payment.TourGeniusPayment.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Optional<List<Payment>> findAllByUserId(String userId);
    Optional<List<Payment>> findAllByClientId(String clientId);
}
