package com.shreepooja.service.impl;

import com.shreepooja.entity.Rating;
import com.shreepooja.entity.Review;
import com.shreepooja.repository.RatingRepository;
import com.shreepooja.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RatingServiceImpl implements RatingService {
    RatingRepository ratingRepository;

    @Override
    public void createRating(String priestId, Rating rating) {
        Review review = new Review();
        review.setPriestId(priestId);
        review.setRatings(List.of(rating));
        //ratingRepository.updateReview(review);
    }

    @Override
    public Review getRating(String priestId) {
        return null;
    }
}
