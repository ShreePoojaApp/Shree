package com.shreepooja.repository;

import com.shreepooja.entity.Booking;
import com.shreepooja.entity.BookingDetails;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
@Slf4j
public class BookingCustomRepositoryImpl implements BookingCustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<BookingDetails> getBookingDetailsWithUsers() {
        //"{'$addFields': { 'user_Id': { '$toObjectId': '$userId' }}}"
        //TODO: Converting userID to objectId as it is required in lookup.
        AddFieldsOperation fieldsOperation = Aggregation.addFields()
                .addFieldWithValue("user_id", ConvertOperators.ToObjectId.toObjectId("$userId"))
                .addFieldWithValue("priest_id", ConvertOperators.ToObjectId.toObjectId("$priestId"))
                .addFieldWithValue("worship_id", ConvertOperators.ToObjectId.toObjectId("$worshipId"))
                .build();

        Aggregation aggregation = Aggregation.newAggregation(
                fieldsOperation,
                Aggregation.lookup("users", "user_id", "_id", "users"),
                Aggregation.lookup("users", "priest_id", "_id", "priests"),
                Aggregation.lookup("worships", "worship_id", "_id", "worships")
        );
        AggregationResults<BookingDetails> results = mongoTemplate.aggregate(aggregation, "bookings", BookingDetails.class);
        log.info("Result: " + results.getMappedResults());
        return results.getMappedResults();
    }

}
