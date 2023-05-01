package com.tourgenius.travellerservice.repository;

import com.tourgenius.travellerservice.model.Traveller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TravellerRepository extends MongoRepository<Traveller, String> {

    Traveller findTravellerByEmail(String email);
    boolean deleteTravellerByEmail(String email);
}
