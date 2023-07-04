package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.TravelerDto;
import com.tourgenius.accountservice.model.Traveler;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;

public interface TravelerService {
    ResponseEntity<String> createTraveller(TravelerDto travelerDto) throws ParseException;
    Traveler updateTraveller(TravelerDto travelerDto) throws ParseException;
    boolean deleteTraveller(String email);
    Traveler getTraveller(String token);
    Date stringToDate(String date) throws ParseException;
}
