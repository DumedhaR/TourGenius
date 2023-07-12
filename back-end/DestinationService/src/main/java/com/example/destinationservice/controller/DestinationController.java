package com.example.destinationservice.controller;

import com.example.destinationservice.model.Destination;
import com.example.destinationservice.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService){
        this.destinationService = destinationService;
    }

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);
    }

    @PostMapping
    public ResponseEntity<Destination> addDestination(@RequestBody Destination destination){
        Destination savedDestination = destinationService.saveDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDestination);
    }
}
