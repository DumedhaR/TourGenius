package com.tourgeniuse.travelerservice.repository;

import com.tourgeniuse.travelerservice.model.Traveler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TravelerRepository extends MongoRepository<Traveler, String> {

    Optional<Traveler> findTravellerByEmail(String email);
    boolean deleteTravellerByEmail(String email);
}
