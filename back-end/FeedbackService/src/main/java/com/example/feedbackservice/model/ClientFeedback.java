package com.example.feedbackservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "clientFeedback")
public class ClientFeedback {
    @Id
    private String id;
    private String clientId;
    private String travellerId;
    private String message;
    private float rating;
}
