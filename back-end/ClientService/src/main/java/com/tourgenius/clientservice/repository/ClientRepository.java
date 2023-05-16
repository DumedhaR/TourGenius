package com.tourgenius.clientservice.repository;

import com.tourgenius.clientservice.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Client findClientByEmail(String email);
    boolean deleteClientByEmail(String email);
}
