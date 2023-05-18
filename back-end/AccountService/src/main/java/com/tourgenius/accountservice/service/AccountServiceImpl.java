package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.config.JwtService;
import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.dto.AuthResponse;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.model.Role;
import com.tourgenius.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse createAccount(@NotNull AccountDto accountDto) {
        Account account = Account.builder()
                .email(accountDto.getEmail())
                .password(passwordEncoder.encode(accountDto.getPassword()))
                .role(Role.TRAVELER)
                .build();
        accountRepository.save(account);
        String token = jwtService.generateToken(account);
        return AuthResponse.builder()
                .jwtToken(token)
                .build();
    }

    @Override
    public AuthResponse authenticate(AccountDto accountDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                accountDto.getEmail(),
                accountDto.getPassword()
        ));
        Account account = accountRepository.findAccountByEmail(accountDto.getEmail())
                .orElseThrow();
        String token = jwtService.generateToken(account);
        return AuthResponse.builder()
                .jwtToken(token)
                .build();
    }

    @Override
    public Account changePassword(@NotNull AccountDto accountDto) {
        Account currentAccount = accountRepository.findAccountByEmail(accountDto.getEmail())
                .orElseThrow();
        currentAccount.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return accountRepository.save(currentAccount);
    }

    @Override
    public boolean deleteAccount(String email) {
        if(accountRepository.findAccountByEmail(email).isEmpty()){
            return false;
        }
        accountRepository.deleteAccountByEmail(email);
        return true;
    }

    @Override
    public String encrypt(String plainText) {
        return new DigestUtils("SHA3-256").digestAsHex(plainText);
    }
}
