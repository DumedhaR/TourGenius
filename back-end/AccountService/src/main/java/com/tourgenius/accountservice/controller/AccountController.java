package com.tourgenius.accountservice.controller;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.service.AccountService;
import com.tourgenius.accountservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<String> register(@RequestBody AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    @PostMapping("/auth")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> authenticate(@RequestBody AccountDto accountDto) {
        return accountService.authenticate(accountDto);
    }

    @PostMapping("/logOut")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> signOut(){
        return accountService.signOut();
    }

    @GetMapping("/get")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> findAccount(
            @CookieValue(name = "accessToken", required = false) String accessToken,
            @CookieValue(name = "refreshToken", required = false) String refreshToken){
        return accountService.getUser(accessToken);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Account changePassword(@RequestBody AccountDto accountDto){
        return accountService.changePassword(accountDto);
    }

    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteAccount(
            @CookieValue(name = "accessToken", required = false) String accessToken,
            @CookieValue(name = "refreshToken", required = false) String refreshToken,
            @PathVariable String email){
        return accountService.deleteAccount(email);
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshAccessToken(@CookieValue(name = "refreshToken", required = false) String refreshToken) {
        return accountService.refreshToken(refreshToken);
    }
}
