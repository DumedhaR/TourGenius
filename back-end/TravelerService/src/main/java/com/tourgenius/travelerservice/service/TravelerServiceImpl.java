package com.tourgenius.travelerservice.service;

import com.tourgenius.travelerservice.dto.AccountDto;
import com.tourgenius.travelerservice.dto.TravelerDto;
import com.tourgenius.travelerservice.exception.AccountIsAvailableException;
import com.tourgenius.travelerservice.model.Traveler;
import com.tourgenius.travelerservice.repository.TravelerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;
    private final RestTemplate restTemplate;

    @Override
    public Traveler createTraveller(@NotNull TravelerDto travelerDto) throws ParseException {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail(travelerDto.getEmail());
        accountDto.setPassword(travelerDto.getPassword());
        accountDto.setRole("Traveler");
        boolean response =
                Objects.equals(Boolean.TRUE, restTemplate.postForObject("http://localhost:9001/accounts/create", accountDto, Boolean.class));
        if(!response){
            throw new AccountIsAvailableException(travelerDto.getEmail());
        }
        Traveler traveler = new Traveler();
        traveler.setFirstName(travelerDto.getFirstName());
        traveler.setLastName(travelerDto.getLastName());
        traveler.setEmail(travelerDto.getEmail());
        traveler.setDateOfBirth(stringToDate(travelerDto.getDateOfBirth()));
        traveler.setCountry(travelerDto.getCountry());
        traveler.setProfilePicture(travelerDto.getProfilePicture());
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
        return travelerRepository.findTravellerByEmail(email);
    }

    @Override
    public String encrypt(String plainText) {
        return new DigestUtils("SHA3-256").digestAsHex(plainText);
    }

    @Override
    public Date stringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.parse(date);
    }
}
