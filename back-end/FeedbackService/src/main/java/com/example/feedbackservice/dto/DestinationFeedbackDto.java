package com.example.feedbackservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DestinationFeedbackDto {
    private String destinationId;
    private String travellerId;
    private String message;
    private float rating;
}