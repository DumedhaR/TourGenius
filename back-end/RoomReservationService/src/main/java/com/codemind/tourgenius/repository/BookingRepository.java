package com.codemind.tourgenius.repository;

import com.codemind.tourgenius.dto.BookingResultDto;
import com.codemind.tourgenius.dto.request.BookingRequest;
import com.codemind.tourgenius.model.Booking;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface BookingRepository extends MongoRepository<Booking,String> {

    List<Booking> getBookingsByUserId(String id);
    List<Booking> getBookingsByClientId(String id);

    @Query("{$and: [" +
            "{clientId: ?0}, {$or: [ " +
            "{$and: [{checkInDate: {$lte: ?1}}, {checkOutDate: {$gte: ?2}}]}, " +
            "{$and: [{checkInDate: {$gt: ?1}}, {checkOutDate: {$lt: ?2}}]}, " +
            "{$and: [{checkInDate: {$gt: ?1, $lte: ?2}}]}, " +
            "{$and: [{checkOutDate: {$gte: ?1, $lt: ?2}}]} " +
            "]}]}")
    List<Booking> findClashingBookings(String clientId, Date checkIn, Date checkOut);
}
