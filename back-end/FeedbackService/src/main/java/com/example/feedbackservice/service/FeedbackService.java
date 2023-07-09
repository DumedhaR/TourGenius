package com.example.feedbackservice.service;

import com.example.feedbackservice.dto.ClientFeedbackDto;
import com.example.feedbackservice.dto.DestinationFeedbackDto;
import com.example.feedbackservice.dto.UpdateDto;
import com.example.feedbackservice.model.ClientFeedback;
import com.example.feedbackservice.model.DestinationFeedback;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FeedbackService {
    ResponseEntity<String> createClientFeedback(ClientFeedbackDto clientFeedbackDto);

    ResponseEntity<String> updateFeedback(UpdateDto updateDto, String id);

    ResponseEntity<String> deleteFeedback(String id);

    ResponseEntity<List<ClientFeedback>> getAllFeedbackByClient(String clientId);

    ResponseEntity<Integer> getClientRating(String clientId);

    ResponseEntity<List<DestinationFeedback>> getAllFeedbackByDestination(String id);

    ResponseEntity<Integer> getDestinationRating(String id);

    ResponseEntity<String> createDestinationFeedback(DestinationFeedbackDto destinationFeedbackDto);
}
