package com.tourgenius.adminservice.repository;

import com.tourgenius.adminservice.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findAdminByEmail(String email);
    boolean deleteAdminByEmail(String email);
}
