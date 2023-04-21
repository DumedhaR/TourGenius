package com.tourgenius.userservice.repository;

import com.tourgenius.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByEmail(String email);
    boolean deleteUserByEmail(String email);
}
