package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
@Service
public class JwtServiceImpl implements JwtService {

    private static final String SecreteKey = "655368566D597133743677397A24432646294A404D635166546A576E5A723475";
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Collection<? extends GrantedAuthority> extractUserRole(String token) {
        final Claims claims = extractAllClaims(token);
        return (Collection<? extends GrantedAuthority>) claims.get("role");
    }

    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(@NotNull UserDetails userDetails, long duration) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", userDetails.getAuthorities());
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + duration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, @NotNull UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return extractExpireDate(token).before(new Date());
    }

    public Date extractExpireDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, @NotNull Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private @NotNull Key getSignInKey() {
        byte[] keyInBytes = Decoders.BASE64.decode(SecreteKey);
        return Keys.hmacShaKeyFor(keyInBytes);
    }
}
