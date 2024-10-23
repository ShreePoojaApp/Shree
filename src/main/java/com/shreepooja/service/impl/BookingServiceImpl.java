package com.shreepooja.service.impl;

import com.shreepooja.entity.Booking;
import com.shreepooja.entity.BookingDetails;
import com.shreepooja.repository.BookingRepository;
import com.shreepooja.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void bookService(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBooking(String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Booking getBookingForAnUser(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<BookingDetails> getBookingAndUserDetails() {
        return bookingRepository.getBookingAndUserDetails();
    }

    @Override
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsOnADay(Date fromDate) {
        return bookingRepository.findByFromDateTime(fromDate);
    }

    @Override
    public List<Booking> getBookingForAPriestOnADay(String userId) {
        return List.of();
    }

    @Override
    public List<Booking> getBookingStatus() {
        return List.of();
    }

    @Override
    public List<Booking> getCancelledBooking() {
        return List.of();
    }

    @Override
    public List<Booking> getCancelledBookingByUser(String userId) {
        return List.of();
    }

    @Override
    public List<Booking> getCancelledBookinByPriest(String userId) {
        return List.of();
    }

    @Override
    public List<Booking> getAllCancelledBookingByUser() {
        return List.of();
    }

    @Override
    public List<Booking> getAllCancelledBookingByPriest() {
        return List.of();
    }

    @Override
    public List<Booking> getBookingStatus(String bookingId) {
        return List.of();
    }

    @Override
    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
