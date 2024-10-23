package com.shreepooja.service;

import com.shreepooja.entity.Booking;
import com.shreepooja.entity.BookingDetails;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    void bookService(Booking booking);
    Optional<Booking> getBooking(String bookingId);
    Booking getBookingForAnUser(String userId);
    List<BookingDetails> getBookingAndUserDetails();
    List<Booking> getBookings();
    List<Booking> getBookingsOnADay(Date fromDate);
    List<Booking> getBookingForAPriestOnADay(String userId);
    List<Booking> getBookingStatus();
    List<Booking> getCancelledBooking();
    List<Booking> getCancelledBookingByUser(String userId);
    List<Booking> getCancelledBookinByPriest(String userId);
    List<Booking> getAllCancelledBookingByUser();
    List<Booking> getAllCancelledBookingByPriest();
    List<Booking> getBookingStatus(String bookingId);
    void deleteBooking(String bookingId);

}
