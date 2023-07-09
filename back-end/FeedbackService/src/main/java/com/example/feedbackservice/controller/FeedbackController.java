package com.example.feedbackservice.controller;

import com.example.feedbackservice.dto.ClientFeedbackDto;
import com.example.feedbackservice.dto.DestinationFeedbackDto;
import com.example.feedbackservice.dto.UpdateDto;
import com.example.feedbackservice.model.ClientFeedback;
import com.example.feedbackservice.model.DestinationFeedback;
import com.example.feedbackservice.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping(value = "/client/create")
    public ResponseEntity<String> createClientFeedback(@RequestBody ClientFeedbackDto clientFeedbackDto){
        return feedbackService.createClientFeedback(clientFeedbackDto);
    }

    @GetMapping(value = "/client/all/{clientId}")
    public ResponseEntity<List<ClientFeedback>> getAllFeedbackByClient(@PathVariable String clientId){
        return feedbackService.getAllFeedbackByClient(clientId);
    }
    @GetMapping(value = "/client/rating/{clientId}")
    public ResponseEntity<Integer> getClientRating(@PathVariable String clientId){
        return feedbackService.getClientRating(clientId);
    }

    @PostMapping(value = "/destination/create")
    public ResponseEntity<String> createDestinationFeedback(@RequestBody DestinationFeedbackDto destinationFeedbackDto){
        return feedbackService.createDestinationFeedback(destinationFeedbackDto);
    }

    @GetMapping(value = "/destination/all/{id}")
    public ResponseEntity<List<DestinationFeedback>> getAllFeedbackByDestination(@PathVariable String id){
        return feedbackService.getAllFeedbackByDestination(id);
    }
    @GetMapping(value = "/destination/rating/{id}")
    public ResponseEntity<Integer> getDestinationRating(@PathVariable String id){
        return feedbackService.getDestinationRating(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateFeedback(@RequestBody UpdateDto updateDto, @PathVariable String id){
        return feedbackService.updateFeedback(updateDto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable String id){
        return feedbackService.deleteFeedback(id);
    }


}
