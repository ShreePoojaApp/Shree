package com.shreepooja.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(collection = "worships")
public class Worship implements Serializable {
    @Id
    private String id;
    @NonNull
    private String worshipName;
    private String worshipDescription;
    private String worshipType;
}
