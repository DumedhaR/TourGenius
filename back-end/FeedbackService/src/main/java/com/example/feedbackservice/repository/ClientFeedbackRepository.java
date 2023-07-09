package com.example.feedbackservice.repository;

import com.example.feedbackservice.model.ClientFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientFeedbackRepository extends MongoRepository<ClientFeedback, String> {
    List<ClientFeedback> findAllByClientId(String ClientId);
}
