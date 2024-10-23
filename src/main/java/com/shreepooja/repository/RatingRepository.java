package com.shreepooja.repository;

import com.shreepooja.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends MongoRepository<Review, String> {
    
    //public void updateReview(Review review);
}
