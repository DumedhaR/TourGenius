package com.example.destinationservice.controller;

import com.example.destinationservice.model.Destination;
import com.example.destinationservice.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService){
        this.destinationService = destinationService;
    }

    @PostMapping
    public ResponseEntity<Destination> addDestination(@RequestBody Destination destination){
        Destination savedDestination = destinationService.saveDestination(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDestination);
    }
}
