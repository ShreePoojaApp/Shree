package com.shreepooja.repository;

import com.shreepooja.entity.Booking;
import com.shreepooja.entity.BookingDetails;
import com.shreepooja.entity.User;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByFromDateTime(Date fromDate);
    Booking findByUserId(String userId);
    @Aggregation(pipeline =
            "{'$addFields': { 'user_Id': { '$toObjectId': '$userId' }}}" +
                    ", {$lookup: {from: 'users', localField: 'user_Id', foreignField: '_id', as: 'user'}}")
    List<BookingDetails> getBookingAndUserDetails();
}
