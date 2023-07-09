package com.tourgenius.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.security.Permission;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    Traveler(Collections.emptySet()),
    Client(Collections.emptySet());
    @Getter
    private final Set<Permission> permissions;
}
