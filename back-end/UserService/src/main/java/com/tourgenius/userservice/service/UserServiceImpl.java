package com.tourgenius.userservice.service;

import com.tourgenius.userservice.dto.AccountDto;
import com.tourgenius.userservice.dto.UserDto;
import com.tourgenius.userservice.exception.AccountIsAvailableException;
import com.tourgenius.userservice.model.User;
import com.tourgenius.userservice.repository.UserRepository;
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
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Override
    public User createUser(@NotNull UserDto userDto) throws ParseException {
        AccountDto accountDto = new AccountDto();
        accountDto.setEmail(userDto.getEmail());
        accountDto.setPassword(userDto.getPassword());
        accountDto.setRole("User");
        boolean response =
                Objects.equals(Boolean.TRUE, restTemplate.postForObject("http://localhost:9001/accounts/create", accountDto, Boolean.class));
        if(!response){
            throw new AccountIsAvailableException(userDto.getEmail());
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setDateOfBirth(stringToDate(userDto.getDateOfBirth()));
        user.setCountry(userDto.getCountry());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(@NotNull UserDto userDto) throws ParseException {
        User currentUser = userRepository.findUserByEmail(userDto.getEmail());
        if(userDto.getFirstName() != null){
            currentUser.setFirstName(userDto.getFirstName());
        }
        if(userDto.getLastName() != null){
            currentUser.setLastName(userDto.getLastName());
        }
        if(userDto.getDateOfBirth() != null){
            currentUser.setDateOfBirth(stringToDate(userDto.getDateOfBirth()));
        }
        if(userDto.getCountry() != null){
            currentUser.setCountry(userDto.getCountry());
        }
        return userRepository.save(currentUser);
    }

    @Override
    public boolean deleteUser(String email) {
        return userRepository.deleteUserByEmail(email);
    }

    @Override
    public String encrypt(String plainText) {
        return new DigestUtils("SHA3-256").digestAsHex(plainText);
    }

    @Override
    public Date stringToDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.parse(date);
    }
}
