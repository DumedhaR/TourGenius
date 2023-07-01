package com.tourgenius.accountservice.controller;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.service.AccountService;
import com.tourgenius.accountservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

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

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Account changePassword(

            @RequestBody @NotNull AccountDto accountDto){
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

    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public boolean verifyToken(@RequestParam("token") String token) {
        String userEmail = jwtService.extractUserName(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
        return jwtService.isTokenValid(token, userDetails);
    }

    @GetMapping("/role")
    @ResponseStatus(HttpStatus.OK)
    public String extractRole(@RequestParam("token") String token) {
        return jwtService.extractUserRole(token);
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshAccessToken( @CookieValue(name = "refreshToken", required = false) String refreshToken) {
        return accountService.refreshToken(refreshToken);
    }
}
