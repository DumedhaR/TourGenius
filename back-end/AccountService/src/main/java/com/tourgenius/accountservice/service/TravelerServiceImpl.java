package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.dto.TravelerDto;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.model.Role;
import com.tourgenius.accountservice.model.Traveler;
import com.tourgenius.accountservice.repository.AccountRepository;
import com.tourgenius.accountservice.repository.TravelerRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;
    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final AccountService accountService;


    @Override
    public ResponseEntity<String> createTraveller(@NotNull TravelerDto travelerDto) throws ParseException {
        AccountDto accountDto = AccountDto.builder()
                .email(travelerDto.getEmail())
                .password(travelerDto.getPassword())
                .role(Role.Traveler)
                .build();
        accountService.createAccount(accountDto);
        Account account = accountRepository.findAccountByEmail(travelerDto.getEmail()).orElseThrow();
        try{
        Traveler traveler = Traveler.builder()
                .firstName(travelerDto.getFirstName())
                .lastName(travelerDto.getLastName())
                .email(travelerDto.getEmail())
                .dateOfBirth(stringToDate(travelerDto.getDateOfBirth()))
                .country(travelerDto.getCountry())
                .profilePicture(travelerDto.getProfilePicture())
                .build();

            travelerRepository.save(traveler);
        }catch (Exception e){
            accountService.deleteAccount(travelerDto.getEmail());
            System.out.println(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.badRequest().body("Error");
        }
        return ResponseEntity.ok().headers(accountService.setTokenCookies(account)).body("Created");
    }

    @Override
    public Traveler updateTraveller(@NotNull TravelerDto travelerDto) throws ParseException {
        Traveler currentTraveler = travelerRepository.findTravellerByEmail(travelerDto.getEmail()).orElseThrow();
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
    public Traveler getTraveller(String token) {
        String userEmail = jwtService.extractUserName(token);
        return travelerRepository.findTravellerByEmail(userEmail).orElseThrow();
    }

    @Override
    public Date stringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.parse(date);
    }
}
