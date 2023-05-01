package com.tourgenius.travellerservice.service;

import com.tourgenius.travellerservice.dto.TravellerDto;
import com.tourgenius.travellerservice.model.Traveller;

import java.text.ParseException;
import java.util.Date;

public interface TravellerService {
    Traveller createTraveller(TravellerDto travellerDto) throws ParseException;

    Traveller updateTraveller(TravellerDto travellerDto) throws ParseException;

    boolean deleteTraveller(String email);
    Traveller getTraveller(String email);
    String encrypt(String plainText);

    Date stringToDate(String date) throws ParseException;
}
