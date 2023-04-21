package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;

public interface AccountService {
    boolean createAccount(AccountDto accountDto);

    Account changePassword(String email, String password);

    boolean deleteAccount(String email);

    boolean authenticateAccount(String email, String password);

    String encrypt(String plainText);
}
