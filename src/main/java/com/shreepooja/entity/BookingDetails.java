package com.shreepooja.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BookingDetails implements Serializable {
    private String id;
    private String userId;
    private String priestId;
    private String cateringId;
    private String worshipId;
    private String fromDateTime;
    private String toDateTime;
    private String user_Id;
    private List<User> user;
}
