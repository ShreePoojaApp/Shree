package com.shreepooja.repository;

import com.shreepooja.entity.BookingDetails;
import org.springframework.data.mongodb.repository.Aggregation;

public interface BooingCustomRepository {

    @Aggregation(pipeline =
            "{'$addFields': { 'user_Id': { '$toObjectId': '$userId' }}}, {$lookup: {from: 'users', localField: 'user_Id', foreignField: '_id', as: 'user'}}")
    BookingDetails getBookingAndUserDetails();
}
