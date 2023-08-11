package com.tourgenius.adminservice.service;

import com.tourgenius.adminservice.dto.AdminDto;
import com.tourgenius.adminservice.model.Admin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    Admin getAdmin(String email);
    boolean deleteAdmin(String email);
    String createAdmin(AdminDto adminDto);
    String updateAdmin(AdminDto adminDto);
    ResponseEntity<String> signIn(AdminDto adminDto);
    ResponseEntity<String> signOut();
    ResponseEntity<String> refreshToken(String refreshToken);
    HttpHeaders setTokenCookies(Admin admin);
}
