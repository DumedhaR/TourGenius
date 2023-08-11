package com.tourgenius.adminservice.repository;

import com.tourgenius.adminservice.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {

    Optional<Admin> findAdminByEmail(String email);
    boolean deleteAdminByEmail(String email);
}
