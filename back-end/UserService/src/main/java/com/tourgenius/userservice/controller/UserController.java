package com.tourgenius.userservice.controller;

import com.tourgenius.userservice.dto.UserDto;
import com.tourgenius.userservice.model.User;
import com.tourgenius.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserDto userDto) throws ParseException {
        return userService.createUser(userDto);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody UserDto userDto) throws ParseException {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/delete/{email}")
    public boolean deleteUser(@PathVariable String email){
        return userService.deleteUser(email);
    }

}
