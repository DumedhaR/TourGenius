package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    ResponseEntity<String> createAccount(AccountDto accountDto);
    ResponseEntity<String> authenticate(AccountDto accountDto);
    Account changePassword(AccountDto accountDto);
    boolean deleteAccount(String email);
    ResponseEntity<String> refreshToken(HttpServletRequest request, HttpServletResponse response);
}
