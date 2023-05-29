package com.tourgenius.clientservice.repository;

import com.tourgenius.clientservice.model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {
    List<Property> getPropertiesByClientId(String id);
    boolean deleteByPropertyId(String id);
}
