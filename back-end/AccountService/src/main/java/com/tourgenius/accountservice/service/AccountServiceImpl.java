package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.config.TokenCookie;
import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.repository.AccountRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    private final TokenCookie tokenCookie;
    @Override
    public ResponseEntity<String> createAccount(@NotNull AccountDto accountDto) {
        boolean isAvailable = accountRepository.findAccountByEmail(accountDto.getEmail()).isPresent();
        if(!isAvailable) {
            Account account = Account.builder()
                    .email(accountDto.getEmail())
                    .password(passwordEncoder.encode(accountDto.getPassword()))
                    .role(accountDto.getRole() == null ? "Traveler" : accountDto.getRole())
                    .build();
            accountRepository.save(account);
            setTokenCookies(account);
            return ResponseEntity.ok().headers(setTokenCookies(account)).body("created");
        }
        throw new IllegalArgumentException("email already used!");
    }

    @Override
    public ResponseEntity<String> authenticate(@NotNull AccountDto accountDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                accountDto.getEmail(),
                accountDto.getPassword()
        ));
        Account account = accountRepository.findAccountByEmail(accountDto.getEmail()).orElseThrow();

        return ResponseEntity.ok().headers(setTokenCookies(account)).body("authenticated");
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
    public ResponseEntity<String> refreshToken(String refreshToken) {
        String userEmail;
        HttpHeaders responseHeaders = new HttpHeaders();
        if(refreshToken == null || jwtService.isTokenExpired(refreshToken)){
            throw new IllegalArgumentException("Refresh Token is invalid!");
        }
        userEmail = jwtService.extractUserName(refreshToken);
        if(!userEmail.isEmpty()){
            var account = accountRepository.findAccountByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshToken,account)){
            var newAccessToken = jwtService.generateToken(account,60 * 60 * 1000);
            addAccessTokenCookie(responseHeaders, newAccessToken);
        }
        }
        return ResponseEntity.ok().headers(responseHeaders).body("refreshed");
    }

    private  HttpHeaders setTokenCookies(Account account) {
        HttpHeaders responseHeaders = new HttpHeaders();
        String newAccessToken = jwtService.generateToken(account,60 * 60 * 1000);
        String newRefreshToken = jwtService.generateToken(account,60 * 60 * 1000 * 24);
        addAccessTokenCookie(responseHeaders, newAccessToken);
        addRefreshTokenCookie(responseHeaders, newRefreshToken);
        return responseHeaders;
    }

    private void addAccessTokenCookie(HttpHeaders httpHeaders, String token) {
        httpHeaders.add(HttpHeaders.SET_COOKIE, tokenCookie.createAccessTokenCookie(token).toString());
    }

    private void addRefreshTokenCookie(HttpHeaders httpHeaders, String token) {
        httpHeaders.add(HttpHeaders.SET_COOKIE, tokenCookie.createRefreshTokenCookie(token).toString());
    }

}
