package com.tourgenius.adminservice.service;

import com.tourgenius.adminservice.dto.AdminDto;
import com.tourgenius.adminservice.model.Admin;
import com.tourgenius.adminservice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository;
    @Override
    public Admin createAdmin(@NotNull AdminDto adminDto) {
        Admin newAdmin = new Admin();
        newAdmin.setEmail(adminDto.getEmail());
        newAdmin.setName(adminDto.getName());
        newAdmin.setPassword(adminDto.getPassword());
        return adminRepository.save(newAdmin);
    }
    @Override
    public Admin updateAdmin(@NotNull AdminDto adminDto) {
        Admin current = getAdmin(adminDto.getEmail());
        if(adminDto.getName() != null){
            current.setName(adminDto.getName());
        }
        if(adminDto.getPassword() != null){
            current.setPassword(adminDto.getPassword());
        }
        return adminRepository.save(current);
    }
    @Override
    public Admin getAdmin(String email) {
        return adminRepository.findAdminByEmail(email);
    }
    @Override
    public boolean deleteAdmin(String email) {
        return adminRepository.deleteAdminByEmail(email);
    }
}
