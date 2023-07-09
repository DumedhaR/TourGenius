package com.example.feedbackservice.service;

import com.example.feedbackservice.dto.ClientFeedbackDto;
import com.example.feedbackservice.dto.DestinationFeedbackDto;
import com.example.feedbackservice.dto.UpdateDto;
import com.example.feedbackservice.model.ClientFeedback;
import com.example.feedbackservice.model.DestinationFeedback;
import com.example.feedbackservice.repository.ClientFeedbackRepository;
import com.example.feedbackservice.repository.DestinationFeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private ClientFeedbackRepository clientFeedbackRepository ;
    private DestinationFeedbackRepository destinationFeedbackRepository;
    @Override
    public ResponseEntity<String> createClientFeedback(ClientFeedbackDto clientFeedbackDto) {
        ClientFeedback clientFeedback = ClientFeedback.builder()
                .clientId(clientFeedbackDto.getClientId())
                .travellerId(clientFeedbackDto.getTravellerId())
                .message(clientFeedbackDto.getMessage())
                .rating(clientFeedbackDto.getRating())
                .build();
        clientFeedbackRepository.save(clientFeedback);
        return ResponseEntity.ok().body("created");
    }

    @Override
    public ResponseEntity<String> updateFeedback(UpdateDto updateDto, String id) {
        ClientFeedback clientFeedback = clientFeedbackRepository.findById(id).orElseThrow();
        if(updateDto.getMessage() != null){
            clientFeedback.setMessage(updateDto.getMessage());
        }
        if(updateDto.getRating() != 0){
            clientFeedback.setRating(updateDto.getRating());
        }
        clientFeedbackRepository.save(clientFeedback);
        return ResponseEntity.ok().body("updated");
    }

    @Override
    public ResponseEntity<String> deleteFeedback(String id) {
        clientFeedbackRepository.findById(id).orElseThrow();
        clientFeedbackRepository.deleteById(id);
        return ResponseEntity.ok().body("Deleted");
    }

    @Override
    public ResponseEntity<List<ClientFeedback>> getAllFeedbackByClient(String clientId) {
        List<ClientFeedback> clientFeedbacks = clientFeedbackRepository.findAllByClientId(clientId);
        return ResponseEntity.ok().body(clientFeedbacks);
    }

    @Override
    public ResponseEntity<Integer> getClientRating(String clientId) {
        List<ClientFeedback> clientFeedbacks = clientFeedbackRepository.findAllByClientId(clientId);
        float ratingCount = 0;
        for (ClientFeedback clientFeedback : clientFeedbacks){
           ratingCount += clientFeedback.getRating();
        }
        float avgRating = ratingCount/ clientFeedbacks.size();
        return ResponseEntity.ok().body(Math.round(avgRating));
    }

    @Override
    public ResponseEntity<String> createDestinationFeedback(DestinationFeedbackDto destinationFeedbackDto) {
        DestinationFeedback destinationFeedback = DestinationFeedback.builder()
                .destinationId(destinationFeedbackDto.getDestinationId())
                .travellerId(destinationFeedbackDto.getTravellerId())
                .message(destinationFeedbackDto.getMessage())
                .rating(destinationFeedbackDto.getRating())
                .build();
        destinationFeedbackRepository.save(destinationFeedback);
        return ResponseEntity.ok().body("created");
    }

    @Override
    public ResponseEntity<List<DestinationFeedback>> getAllFeedbackByDestination(String id) {
        List<DestinationFeedback> destinationFeedbacks = destinationFeedbackRepository.findAllByDestinationId(id);
        return ResponseEntity.ok().body(destinationFeedbacks);
    }

    @Override
    public ResponseEntity<Integer> getDestinationRating(String id) {
        List<DestinationFeedback> destinationFeedbacks = destinationFeedbackRepository.findAllByDestinationId(id);
        float ratingCount = 0;
        for (DestinationFeedback destinationFeedback : destinationFeedbacks){
            ratingCount += destinationFeedback.getRating();
        }
        float avgRating = ratingCount/ destinationFeedbacks.size();
        return ResponseEntity.ok().body(Math.round(avgRating));
    }

}
