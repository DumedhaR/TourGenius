package com.codemind.tourgenius.repository;

import com.codemind.tourgenius.model.Booking;
import com.codemind.tourgenius.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking,Long> {
}
