package com.tourgenius.adminservice.controller;

import com.tourgenius.adminservice.dto.AdminDto;
import com.tourgenius.adminservice.model.Admin;
import com.tourgenius.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody AdminDto adminDto){
        return adminService.createAdmin(adminDto);
    }
    @PutMapping("/update")
    public String updateAdmin(@RequestBody AdminDto adminDto){
        return adminService.updateAdmin(adminDto);
    }
    @DeleteMapping("/delete/{email}")
    public boolean deleteAdmin(@PathVariable String email){
        return adminService.deleteAdmin(email);
    }
    @GetMapping("/get/{email}")
    public Admin getAdmin(@PathVariable String email){
        return adminService.getAdmin(email);
    }
    @PostMapping("/signIn")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> signIn(@RequestBody AdminDto adminDto) {
        return adminService.signIn(adminDto);
    }
    @PostMapping("/signOut")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> signOut(){
        return adminService.signOut();
    }
    @PostMapping("/refresh")
    public ResponseEntity<String> refreshAccessToken(@CookieValue(name = "refreshToken", required = false) String refreshToken) {
        return adminService.refreshToken(refreshToken);
    }
}
