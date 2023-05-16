package com.tourgenius.travelerservice.service;

import com.tourgenius.travelerservice.dto.TravelerDto;
import com.tourgenius.travelerservice.model.Traveler;

import java.text.ParseException;
import java.util.Date;

public interface TravelerService {
    Traveler createTraveller(TravelerDto travelerDto) throws ParseException;

    Traveler updateTraveller(TravelerDto travelerDto) throws ParseException;

    boolean deleteTraveller(String email);
    Traveler getTraveller(String email);
    String encrypt(String plainText);

    Date stringToDate(String date) throws ParseException;
}
