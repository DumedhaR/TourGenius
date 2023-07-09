package com.example.feedbackservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "destinationFeedback")
public class DestinationFeedback {
    @Id
    private String id;
    private String destinationId;
    private String travellerId;
    private String message;
    private float rating;
}
