package com.tourgenius.adminservice.controller;

import com.tourgenius.adminservice.dto.AdminDto;
import com.tourgenius.adminservice.model.Admin;
import com.tourgenius.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    AdminService adminService;

    @PostMapping("/create")
    public Admin createAdmin(@RequestBody AdminDto adminDto){
        return adminService.createAdmin(adminDto);
    }
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody AdminDto adminDto){
        return adminService.updateAdmin(adminDto);
    }
    @DeleteMapping("/delete/{email}")
    public boolean deleteAdmin(@PathVariable String email){
        return adminService.deleteAdmin(email);
    }
    @GetMapping("/{email}")
    public Admin getAdmin(@PathVariable String email){
        return adminService.getAdmin(email);
    }
}
