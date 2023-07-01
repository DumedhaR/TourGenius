package com.tourgeniuse.travelerservice.service;
import com.tourgeniuse.travelerservice.dto.TravelerDto;
import com.tourgeniuse.travelerservice.model.Traveler;
import com.tourgeniuse.travelerservice.repository.TravelerRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;

    @Override
    public Traveler createTraveller(@NotNull TravelerDto travelerDto) throws ParseException {
        Traveler traveler = Traveler.builder()
                .firstName(travelerDto.getFirstName())
                .lastName(travelerDto.getLastName())
                .email(travelerDto.getEmail())
                .dateOfBirth(stringToDate(travelerDto.getDateOfBirth()))
                .country(travelerDto.getCountry())
                .profilePicture(travelerDto.getProfilePicture())
                .build();
        return travelerRepository.save(traveler);
    }

    @Override
    public Traveler updateTraveller(@NotNull TravelerDto travelerDto) throws ParseException {
        Traveler currentTraveler = getTraveller(travelerDto.getEmail());
        if(travelerDto.getFirstName() != null){
            currentTraveler.setFirstName(travelerDto.getFirstName());
        }
        if(travelerDto.getLastName() != null){
            currentTraveler.setLastName(travelerDto.getLastName());
        }
        if(travelerDto.getDateOfBirth() != null){
            currentTraveler.setDateOfBirth(stringToDate(travelerDto.getDateOfBirth()));
        }
        if(travelerDto.getCountry() != null){
            currentTraveler.setCountry(travelerDto.getCountry());
        }
        if(travelerDto.getProfilePicture() != null){
            currentTraveler.setProfilePicture(travelerDto.getProfilePicture());
        }
        return travelerRepository.save(currentTraveler);
    }

    @Override
    public boolean deleteTraveller(String email) {
        return travelerRepository.deleteTravellerByEmail(email);
    }

    @Override
    public Traveler getTraveller(String email) {
        return travelerRepository.findTravellerByEmail(email).orElseThrow();
    }

    @Override
    public Date stringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.parse(date);
    }
}
