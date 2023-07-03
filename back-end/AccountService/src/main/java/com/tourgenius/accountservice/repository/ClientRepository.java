package com.tourgenius.accountservice.repository;

import com.tourgenius.accountservice.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findClientByEmail(String email);
    boolean deleteClientByEmail(String email);

}
