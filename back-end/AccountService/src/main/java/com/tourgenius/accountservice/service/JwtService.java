package com.tourgenius.accountservice.service;

import io.jsonwebtoken.Claims;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

public interface JwtService {
    String extractUserName(String token);
    Collection<? extends GrantedAuthority> extractUserRole(String token);
    Claims extractAllClaims(String token);
    String generateToken(UserDetails userDetails, long duration);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
    Date extractExpireDate(String token);

}
