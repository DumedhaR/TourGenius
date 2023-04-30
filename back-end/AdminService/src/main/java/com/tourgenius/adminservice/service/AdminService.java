package com.tourgenius.adminservice.service;

import com.tourgenius.adminservice.model.Admin;

public interface AdminService {
    Admin findAdminByEmail(Admin adminDto);
}
