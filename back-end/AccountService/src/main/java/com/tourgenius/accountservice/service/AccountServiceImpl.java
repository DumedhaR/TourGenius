package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.config.TokenCookie;
import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.model.Client;
import com.tourgenius.accountservice.model.Role;
import com.tourgenius.accountservice.model.Traveler;
import com.tourgenius.accountservice.repository.AccountRepository;
import com.tourgenius.accountservice.repository.ClientRepository;
import com.tourgenius.accountservice.repository.TravelerRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenCookie tokenCookie;
    private TravelerRepository travelerRepository;
    private ClientRepository clientRepository;
    @Override
    public String createAccount(@NotNull AccountDto accountDto) {

        boolean isAvailable = accountRepository.findAccountByEmail(accountDto.getEmail()).isPresent();
        if(!isAvailable) {
            Account account = Account.builder()
                    .email(accountDto.getEmail())
                    .password(passwordEncoder.encode(accountDto.getPassword()))
                    .role(accountDto.getRole() == null ? Role.Traveler : accountDto.getRole())
                    .build();
            accountRepository.save(account);
            return "created";
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
        HttpHeaders headers = setTokenCookies(account);
        return ResponseEntity.ok().headers(headers).body("authenticated");
    }

    @Override
    public ResponseEntity<String> signOut() {
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add(HttpHeaders.SET_COOKIE, tokenCookie.deleteRefreshTokenCookie().toString());
        responseHeader.add(HttpHeaders.SET_COOKIE, tokenCookie.deleteAccessTokenCookie().toString());
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().headers(responseHeader).body("logOut successful");
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
        accountRepository.existsById(email);
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
            Account account = accountRepository.findAccountByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshToken,account)){
            String newAccessToken = jwtService.generateToken(account,60 * 60 * 1000);
            addAccessTokenCookie(responseHeaders, newAccessToken);
        }
        }
        return ResponseEntity.ok().headers(responseHeaders).body("refreshed");
    }

    @Override
    public ResponseEntity<?> getUser(String accessToken) {
        String userEmail = jwtService.extractUserName(accessToken);
        Account user  = accountRepository.findAccountByEmail(userEmail).orElseThrow();
        if(user.getRole().equals(Role.Traveler)){
            Traveler traveler = travelerRepository.findTravellerByEmail(userEmail).orElseThrow();
            return ResponseEntity.ok().body(traveler);
        }
        else if(user.getRole().equals(Role.Client)){
            Client client = clientRepository.findClientByEmail(userEmail).orElseThrow();
            return ResponseEntity.ok().body(client);
        }
        return ResponseEntity.badRequest().body("No account found");
    }

    @Override
    public HttpHeaders setTokenCookies(Account account) {
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
