package com.tourgenius.adminservice.service;

import com.tourgenius.adminservice.config.TokenCookie;
import com.tourgenius.adminservice.dto.AdminDto;
import com.tourgenius.adminservice.model.Admin;
import com.tourgenius.adminservice.model.Role;
import com.tourgenius.adminservice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final TokenCookie tokenCookie;
    private final AuthenticationManager authenticationManager;
    @Override
    public ResponseEntity<String> createAdmin(@NotNull AdminDto adminDto) {
        boolean isAvailable = adminRepository.findAdminByEmail(adminDto.getEmail()).isPresent();
        if(!isAvailable){
            Admin newAdmin = new Admin();
            newAdmin.setEmail(adminDto.getEmail());
            newAdmin.setFirstName(adminDto.getFirstName());
            newAdmin.setLastName(adminDto.getLastName());
            newAdmin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
            newAdmin.setRole(Role.Admin);
            adminRepository.save(newAdmin);
            return ResponseEntity.ok().headers(setTokenCookies(newAdmin)).body("Created");
        }
        throw new IllegalArgumentException("Email already used!");
    }
    @Override
    public String updateAdmin(@NotNull AdminDto adminDto) {
        Admin current = getAdmin(adminDto.getEmail());
        if(adminDto.getFirstName() != null){
            current.setFirstName(adminDto.getFirstName());
        }
        if(adminDto.getLastName() != null){
            current.setLastName(adminDto.getLastName());
        }
        if(adminDto.getPassword() != null){
            current.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        }
        adminRepository.save(current);
        return "Updated";
    }
    @Override
    public Admin getAdmin(String email) {
        return adminRepository.findAdminByEmail(email).orElseThrow();
    }
    @Override
    public boolean deleteAdmin(String email) {
        return adminRepository.deleteAdminByEmail(email);
    }

    @Override
    public ResponseEntity<String> signIn(@NotNull AdminDto adminDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                adminDto.getEmail(),
                adminDto.getPassword()
        ));
        Admin admin = adminRepository.findAdminByEmail(adminDto.getEmail()).orElseThrow();
        HttpHeaders headers = setTokenCookies(admin);
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
    public HttpHeaders setTokenCookies(Admin admin) {
        HttpHeaders responseHeaders = new HttpHeaders();
        String newAccessToken = jwtService.generateToken(admin,60 * 60 * 1000);
        String newRefreshToken = jwtService.generateToken(admin,60 * 60 * 1000 * 24);
        addAccessTokenCookie(responseHeaders, newAccessToken);
        addRefreshTokenCookie(responseHeaders, newRefreshToken);
        return responseHeaders;
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
            Admin admin = adminRepository.findAdminByEmail(userEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshToken,admin)){
                String newAccessToken = jwtService.generateToken(admin,60 * 60 * 1000);
                addAccessTokenCookie(responseHeaders, newAccessToken);
            }
        }
        return ResponseEntity.ok().headers(responseHeaders).body("refreshed");
    }

    private void addAccessTokenCookie(HttpHeaders httpHeaders, String token) {
        httpHeaders.add(HttpHeaders.SET_COOKIE, tokenCookie.createAccessTokenCookie(token).toString());
    }

    private void addRefreshTokenCookie(HttpHeaders httpHeaders, String token) {
        httpHeaders.add(HttpHeaders.SET_COOKIE, tokenCookie.createRefreshTokenCookie(token).toString());
    }

}
