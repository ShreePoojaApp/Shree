package com.shreepooja.controller;

import com.shreepooja.entity.Rating;
import com.shreepooja.entity.Review;
import com.shreepooja.exception.ResourceNotFoundException;
import com.shreepooja.service.RatingService;
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

@Slf4j
@RestController
@RequestMapping(value = "/rating")
@SecurityRequirement(name = "Keycloak")
public class ReviewController {
    @Autowired
    MessageSourceConfig messageSourceConfig;
    /*@Autowired
    KeyCloakService keyCloakService;*/
    @Autowired
    private RatingService ratingSevice;


    @PostMapping("/{priestId}")
    //@PreAuthorize("hasRole('admin')")
    public ResponseEntity<ApiResponse> reviewAService(String priestId, Rating rating) {
        ratingSevice.createRating(priestId, rating);
        final ApiResponse apiResponse = GenericCommonUtils.buildResponse(null, "Success.",
                true, HttpStatus.OK.value(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{priestId}")
    public ResponseEntity<ApiResponse> getReview(String priestId) {
        log.info("Getting Ratings for a priest {}", priestId);
        final Review reviews = ratingSevice.getRating(priestId);
        if (reviews == null) {
            String message = messageSourceConfig.getString("error.user.notfound", priestId);
            throw  new ResourceNotFoundException(message);
        } else {
            final ApiResponse apiResponse = GenericCommonUtils.buildResponse(reviews, "Success.",
                    true, HttpStatus.OK.value(), null);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
    }

}
