package com.tourgenius.travellerservice.repository;

import com.tourgenius.travellerservice.model.Traveller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends MongoRepository<Traveller, String> {

    Traveller findTravellerByEmail(String email);
    boolean deleteTravellerByEmail(String email);
}
