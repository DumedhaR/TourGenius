package com.example.feedbackservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientFeedbackDto {
    private String clientId;
    private String travellerId;
    private String message;
    private float rating;
}
