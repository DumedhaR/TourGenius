package com.codemind.tourgenius.repository;

import com.codemind.tourgenius.model.ClientPackage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPackageRepository extends MongoRepository<ClientPackage,String> {

}
