package com.tourgenius.adminservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.security.Permission;
import java.util.Collections;
import java.util.Set;

@RequiredArgsConstructor
public enum Role {
    Admin(Collections.emptySet());
    @Getter
    private final Set<Permission> permissions;
}
