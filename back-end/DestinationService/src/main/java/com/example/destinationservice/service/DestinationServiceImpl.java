package com.example.destinationservice.service;

import com.example.destinationservice.model.Destination;
import com.example.destinationservice.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService{
    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public List<Destination> getAllDestinations(){
        return destinationRepository.findAll();
    }
}
