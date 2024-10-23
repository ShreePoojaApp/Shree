package com.shreepooja.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Address implements Serializable {
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String country;
    private String pincode;
}
