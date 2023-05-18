package com.tourgenius.accountservice.controller;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.dto.AuthResponse;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public AuthResponse register(@RequestBody AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    @PostMapping("/auth")
    @ResponseStatus(value = HttpStatus.OK)
    public AuthResponse authenticate(@RequestBody AccountDto accountDto) {
        return accountService.authenticate(accountDto);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Account changePassword(@RequestBody @NotNull AccountDto accountDto){
        return accountService.changePassword(accountDto);
    }

    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteAccount(@PathVariable String email){
        return accountService.deleteAccount(email);
    }

}
