package com.shreepooja.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "reviews")
public class Review {
    private String id;
    private String priestId;
    private float averageRatings;
    private List<Rating> ratings;
}
