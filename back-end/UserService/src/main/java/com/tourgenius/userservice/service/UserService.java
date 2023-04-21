package com.tourgenius.userservice.service;

import com.tourgenius.userservice.dto.UserDto;
import com.tourgenius.userservice.model.User;

import java.text.ParseException;
import java.util.Date;

public interface UserService {
    User createUser(UserDto userDto) throws ParseException;

    User updateUser(UserDto userDto) throws ParseException;

    boolean deleteUser(String email);

    String encrypt(String plainText);

    Date stringToDate(String date) throws ParseException;
}
