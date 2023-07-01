package com.tourgeniuse.travelerservice.service;

import com.tourgeniuse.travelerservice.dto.TravelerDto;
import com.tourgeniuse.travelerservice.model.Traveler;

import java.text.ParseException;
import java.util.Date;

public interface TravelerService {
    Traveler createTraveller(TravelerDto travelerDto) throws ParseException;
    Traveler updateTraveller(TravelerDto travelerDto) throws ParseException;
    boolean deleteTraveller(String email);
    Traveler getTraveller(String email);
    Date stringToDate(String date) throws ParseException;
}
