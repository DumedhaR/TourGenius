package com.tourgenius.travelerservice.repository;

import com.tourgenius.travelerservice.model.Traveler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelerRepository extends MongoRepository<Traveler, String> {

    Traveler findTravellerByEmail(String email);
    boolean deleteTravellerByEmail(String email);
}
