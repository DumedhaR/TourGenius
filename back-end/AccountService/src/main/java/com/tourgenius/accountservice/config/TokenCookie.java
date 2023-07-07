package com.tourgenius.accountservice.config;

import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class TokenCookie {

    private final String value = "not";

    public HttpCookie createAccessTokenCookie(String token) {
        return ResponseCookie.from("accessToken", token)
                .maxAge(60 * 60 )
                .httpOnly(true)
                .path("/")
                .build();
    }

    public HttpCookie createRefreshTokenCookie(String token) {
        return ResponseCookie.from("refreshToken", token)
                .maxAge(60 * 60 * 24 )
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
