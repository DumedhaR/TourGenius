package com.example.feedbackservice.repository;

import com.example.feedbackservice.model.DestinationFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DestinationFeedbackRepository extends MongoRepository<DestinationFeedback, String> {
    List<DestinationFeedback> findAllByDestinationId(String id);

}
