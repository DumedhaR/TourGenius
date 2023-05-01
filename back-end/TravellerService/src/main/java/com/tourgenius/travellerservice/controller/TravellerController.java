package com.tourgenius.travellerservice.controller;

import com.tourgenius.travellerservice.dto.TravellerDto;
import com.tourgenius.travellerservice.model.Traveller;
import com.tourgenius.travellerservice.service.TravellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class TravellerController {

    private final TravellerService travellerService;

    @PostMapping("/create")
    public Traveller createUser(@RequestBody TravellerDto travellerDto) throws ParseException {
        return travellerService.createTraveller(travellerDto);
    }

    @PutMapping("/update")
    public Traveller updateUser(@RequestBody TravellerDto travellerDto) throws ParseException {
        return travellerService.updateTraveller(travellerDto);
    }

    @DeleteMapping("/delete/{email}")
    public boolean deleteUser(@PathVariable String email){
        return travellerService.deleteTraveller(email);
    }

}
