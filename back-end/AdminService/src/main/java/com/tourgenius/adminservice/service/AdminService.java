package com.tourgenius.adminservice.service;

import com.tourgenius.adminservice.dto.AdminDto;
import com.tourgenius.adminservice.model.Admin;

public interface AdminService {
    Admin getAdmin(String email);
    boolean deleteAdmin(String email);
    Admin createAdmin(AdminDto adminDto);
    Admin updateAdmin(AdminDto adminDto);
}
