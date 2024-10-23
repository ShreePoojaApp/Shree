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
@Document(collection = "bookings")
public class Booking implements Serializable {
    @Id
    private String id;
    @NonNull
    private String userId;
    @NonNull
    private String priestId;
    private String cateringId;
    private String worshipId;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
}
