package com.tourgenius.accountservice.controller;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public boolean createAccount(@RequestBody AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Account changePassword(@RequestBody @NotNull AccountDto accountDto){
        return accountService.changePassword(accountDto.getEmail(), accountDto.getPassword());
    }

    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteAccount(@PathVariable String email){
        return accountService.deleteAccount(email);
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public boolean authenticateAccount(@RequestBody @NotNull Account account){
        return accountService.authenticateAccount(account.getAccountId(), account.getPassword());
    }
}
