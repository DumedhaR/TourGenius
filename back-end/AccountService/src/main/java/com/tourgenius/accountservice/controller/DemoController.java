package com.tourgenius.accountservice.controller;

import com.tourgenius.accountservice.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/demo")
@RequiredArgsConstructor
public class DemoController {
    @GetMapping("/greet")
    @ResponseStatus(value = HttpStatus.OK)
    public String Greeting(@CookieValue(name = "accessToken", required = false) String accessToken,
                           @CookieValue(name = "refreshToken", required = false) String refreshToken){
        return "You have access now!";
    }
}
