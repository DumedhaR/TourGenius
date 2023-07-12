package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    String createAccount(AccountDto accountDto);
    ResponseEntity<String> authenticate(AccountDto accountDto);
    ResponseEntity<String> signOut();
    Account changePassword(AccountDto accountDto);
    boolean deleteAccount(String email);
    ResponseEntity<String> refreshToken(String refreshToken);
    ResponseEntity<?> getUser(String accessToken);
    HttpHeaders setTokenCookies(Account account);
}
