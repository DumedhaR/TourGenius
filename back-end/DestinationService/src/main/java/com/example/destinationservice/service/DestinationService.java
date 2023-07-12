package com.example.destinationservice.service;

import com.example.destinationservice.model.Destination;

import java.util.List;

public interface DestinationService {
    Destination saveDestination(Destination destination);
    List<Destination> getAllDestinations();
    Destination getDestinationById(String id);
    void deleteDestinationById(String id);
}
