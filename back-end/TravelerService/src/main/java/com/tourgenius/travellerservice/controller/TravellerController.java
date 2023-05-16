package com.tourgenius.travellerservice.controller;

import com.tourgenius.travellerservice.dto.TravellerDto;
import com.tourgenius.travellerservice.model.Traveller;
import com.tourgenius.travellerservice.service.TravellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/travellers")
@RequiredArgsConstructor
public class TravellerController {

    private final TravellerService travellerService;

    @PostMapping("/create")
    public Traveller createTraveller(@RequestBody TravellerDto travellerDto) throws ParseException {
        return travellerService.createTraveller(travellerDto);
    }

    @PutMapping("/update")
    public Traveller updateTraveller(@RequestBody TravellerDto travellerDto) throws ParseException {
        return travellerService.updateTraveller(travellerDto);
    }

    @DeleteMapping("/delete/{email}")
    public boolean deleteTraveller(@PathVariable String email){
        return travellerService.deleteTraveller(email);
    }

    @GetMapping("/{email}")
    public Traveller getTraveller(@PathVariable String email){
        return travellerService.getTraveller(email);
    }

}
