package com.tourgenius.accountservice.config;

import jakarta.servlet.http.Cookie;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class TokenCookie {

    public HttpCookie createAccessTokenCookie(String token) {
        return ResponseCookie.from("accessToken", token)
                .maxAge(60 * 60 * 1000)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie createRefreshTokenCookie(String token) {
        return ResponseCookie.from("refreshToken", token)
                .maxAge(60 * 60 * 24 * 1000)
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from("accessToken", "").maxAge(0).httpOnly(true).path("/").build();
    }

    public HttpCookie deleteRefreshTokenCookie() {
        return ResponseCookie.from("refreshToken", "").maxAge(0).httpOnly(true).path("/").build();
    }
}
