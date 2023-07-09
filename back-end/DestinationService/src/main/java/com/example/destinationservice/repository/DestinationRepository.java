package com.example.destinationservice.repository;

import com.example.destinationservice.model.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends MongoRepository<Destination,String>{

}
