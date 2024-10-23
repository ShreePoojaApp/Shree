package com.shreepooja.service;

import com.shreepooja.entity.Rating;
import com.shreepooja.entity.Review;

public interface RatingService {
    void createRating(String priestId, Rating rating);
    Review getRating(String priestId);
}
