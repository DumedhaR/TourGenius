package com.tourgenius.travelerservice.controller;

import com.tourgenius.travelerservice.dto.TravelerDto;
import com.tourgenius.travelerservice.model.Traveler;
import com.tourgenius.travelerservice.service.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/traveler")
@RequiredArgsConstructor
public class TravelerController {

    private final TravelerService travelerService;

    @PostMapping("/create")
    public Traveler createTraveller(@RequestBody TravelerDto travelerDto) throws ParseException {
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

    @GetMapping("/{email}")
    public Traveler getTraveller(@PathVariable String email){
        return travelerService.getTraveller(email);
    }

}
