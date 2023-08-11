package com.tourgenius.adminservice.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public interface JwtService {
    String extractUserName(String token);
    Claims extractAllClaims(String token);
    String generateToken(UserDetails userDetails, long duration);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
    Date extractExpireDate(String token);

}
