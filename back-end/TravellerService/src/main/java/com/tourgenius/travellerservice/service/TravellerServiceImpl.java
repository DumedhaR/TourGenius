package com.tourgenius.travellerservice.service;

import com.tourgenius.travellerservice.dto.AccountDto;
import com.tourgenius.travellerservice.dto.TravellerDto;
import com.tourgenius.travellerservice.exception.AccountIsAvailableException;
import com.tourgenius.travellerservice.model.Traveller;
import com.tourgenius.travellerservice.repository.TravellerRepository;
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
public class TravellerServiceImpl implements TravellerService {

    private final TravellerRepository travellerRepository;
    private final RestTemplate restTemplate;

    @Override
    public Traveller createTraveller(@NotNull TravellerDto travellerDto) throws ParseException {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail(travellerDto.getEmail());
        accountDto.setPassword(travellerDto.getPassword());
        accountDto.setRole("Traveller");
        boolean response =
                Objects.equals(Boolean.TRUE, restTemplate.postForObject("http://localhost:9001/accounts/create", accountDto, Boolean.class));
        if(!response){
            throw new AccountIsAvailableException(travellerDto.getEmail());
        }
        Traveller traveller = new Traveller();
        traveller.setFirstName(travellerDto.getFirstName());
        traveller.setLastName(travellerDto.getLastName());
        traveller.setEmail(travellerDto.getEmail());
        traveller.setDateOfBirth(stringToDate(travellerDto.getDateOfBirth()));
        traveller.setCountry(travellerDto.getCountry());
        traveller.setProfilePicture(travellerDto.getProfilePicture());
        return travellerRepository.save(traveller);
    }

    @Override
    public Traveller updateTraveller(@NotNull TravellerDto travellerDto) throws ParseException {
        Traveller currentTraveller = getTraveller(travellerDto.getEmail());
        if(travellerDto.getFirstName() != null){
            currentTraveller.setFirstName(travellerDto.getFirstName());
        }
        if(travellerDto.getLastName() != null){
            currentTraveller.setLastName(travellerDto.getLastName());
        }
        if(travellerDto.getDateOfBirth() != null){
            currentTraveller.setDateOfBirth(stringToDate(travellerDto.getDateOfBirth()));
        }
        if(travellerDto.getCountry() != null){
            currentTraveller.setCountry(travellerDto.getCountry());
        }
        if(travellerDto.getProfilePicture() != null){
            currentTraveller.setProfilePicture(travellerDto.getProfilePicture());
        }
        return travellerRepository.save(currentTraveller);
    }

    @Override
    public boolean deleteTraveller(String email) {
        return travellerRepository.deleteTravellerByEmail(email);
    }

    @Override
    public Traveller getTraveller(String email) {
        return travellerRepository.findTravellerByEmail(email);
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
