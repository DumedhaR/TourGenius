package com.tourgenius.accountservice.controller;

import com.tourgenius.accountservice.dto.TravelerDto;
import com.tourgenius.accountservice.model.Traveler;
import com.tourgenius.accountservice.service.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/traveler")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
public class TravelerController {

    private final TravelerService travelerService;

    @PostMapping("/create")
    public ResponseEntity<String> createTraveller(@RequestBody TravelerDto travelerDto) throws ParseException {
        return travelerService.createTraveller(travelerDto);
    }

    @PutMapping("/update")
    public Traveler updateTraveller(@RequestBody TravelerDto travelerDto) throws ParseException {
        return travelerService.updateTraveller(travelerDto);
    }

    @DeleteMapping("/delete/{email}")
    public boolean deleteTraveller(@PathVariable String email){
        return travelerService.deleteTraveller(email);
    }

    @GetMapping("/get")
    public Traveler getTraveller(@CookieValue(name = "accessToken", required = false) String accessToken){
        return travelerService.getTraveller(accessToken);
    }

}
