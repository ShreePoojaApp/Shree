package com.shreepooja.repository;

import com.shreepooja.entity.Booking;
import com.shreepooja.entity.BookingDetails;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String>, BookingCustomRepository {
    List<Booking> findByFromDateTime(Date fromDate);
    Booking findByUserId(String userId);
}
