package com.example.feedbackservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateDto {
    private String message;
    private float rating;
}
