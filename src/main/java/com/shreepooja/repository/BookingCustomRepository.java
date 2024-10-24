package com.shreepooja.repository;

import com.shreepooja.entity.BookingDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingCustomRepository {

    List<BookingDetails> getBookingDetailsWithUsers();
}
