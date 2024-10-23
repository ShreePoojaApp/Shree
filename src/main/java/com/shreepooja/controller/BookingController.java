package com.shreepooja.controller;

import com.shreepooja.entity.Booking;
import com.shreepooja.entity.BookingDetails;
import com.shreepooja.entity.User;
import com.shreepooja.exception.ResourceNotFoundException;
import com.shreepooja.service.BookingService;
import com.shreepooja.utils.ApiResponse;
import com.shreepooja.utils.GenericCommonUtils;
import com.shreepooja.utils.MessageSourceConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/booking")
@SecurityRequirement(name = "Keycloak")
public class BookingController {
    @Autowired
    MessageSourceConfig messageSourceConfig;
    /*@Autowired
    KeyCloakService keyCloakService;*/
    @Autowired
    private BookingService bookingService;


    @PostMapping
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<ApiResponse> bookService(Booking serviceDetails) {
        bookingService.bookService(serviceDetails);

        final ApiResponse apiResponse = GenericCommonUtils.buildResponse(null, "Success.",
                true, HttpStatus.OK.value(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> bookService(String bookingId) {
        log.info("Getting booking details for booking id {}", bookingId);
        final Optional<Booking> booking = bookingService.getBooking(bookingId);
        if (booking.isEmpty()) {
            String message = messageSourceConfig.getString("error.user.notfound", bookingId);
            throw  new ResourceNotFoundException(message);
        } else {
            final ApiResponse apiResponse = GenericCommonUtils.buildResponse(booking, "Success.",
                    true, HttpStatus.OK.value(), null);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<ApiResponse> getBookingForAnUser(String userId) {
       log.info("Getting booking details for userId {}", userId);
        Booking booking = bookingService.getBookingForAnUser(userId);
        if (booking == null) {
            String message = messageSourceConfig.getString("error.user.notfound", userId);
            throw  new ResourceNotFoundException(message);
        } else {
            final ApiResponse apiResponse = GenericCommonUtils.buildResponse(booking, "Success.",
                    true, HttpStatus.OK.value(), null);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/user/details")
    public ResponseEntity<ApiResponse> getBookingAndUserDetails() {
        log.info("Getting booking details");
        List<BookingDetails> booking = bookingService.getBookingAndUserDetails();
        if (booking == null) {
            String message = messageSourceConfig.getString("error.user.notfound");
            throw  new ResourceNotFoundException(message);
        } else {
            final ApiResponse apiResponse = GenericCommonUtils.buildResponse(booking, "Success.",
                    true, HttpStatus.OK.value(), null);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
    }

}
