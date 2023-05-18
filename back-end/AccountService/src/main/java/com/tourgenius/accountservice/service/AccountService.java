package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.dto.AuthResponse;
import com.tourgenius.accountservice.model.Account;

public interface AccountService {

    AuthResponse createAccount(AccountDto accountDto);
    AuthResponse authenticate(AccountDto accountDto);
    Account changePassword(AccountDto accountDto);
    boolean deleteAccount(String email);
    String encrypt(String plainText);
}
