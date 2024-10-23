package com.shreepooja.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class User implements Serializable {
    @Id
    private String id;
    @NonNull
    private String firstName;
    private String lastName = null;
    private String gender = null;
    @NonNull
    private String email = null;
    @NonNull
    private Integer contactNumber;
    @NonNull
    private String role;
    private Address address;
}
