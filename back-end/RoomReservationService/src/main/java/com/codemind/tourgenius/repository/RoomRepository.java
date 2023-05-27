package com.codemind.tourgenius.repository;

import com.codemind.tourgenius.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RoomRepository extends MongoRepository<Room,Long> {

    @Query(value = "{type: ?0 , availability:true}", count = true)
    public long count2(String type);
}
