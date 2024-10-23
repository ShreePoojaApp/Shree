package com.shreepooja.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Rating implements Serializable {
    @Id
    private String id;
    @NonNull
    private String userId;
    @NonNull
    private String bookingId;
    //TODO: Add validation to rate value to be between 1 and 5 only.
    private int rating; // Rating out of 5
    private String comment;
    //  current date/time.
    private LocalDateTime reviewDateTime;
}
