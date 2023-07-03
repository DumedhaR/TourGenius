package com.codemind.tourgenius.repository;

import com.codemind.tourgenius.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String> {
    @Query(fields = "{ 'id' : 1 }")
    List<Room> getRoomsByPackageId(String packageId);
}
