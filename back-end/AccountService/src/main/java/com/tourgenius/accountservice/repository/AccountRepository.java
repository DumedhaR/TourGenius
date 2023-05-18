package com.tourgenius.accountservice.repository;

import com.tourgenius.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository <Account, String> {
    Optional <Account> findAccountByEmail(String email);
    void deleteAccountByEmail(String email);

}
