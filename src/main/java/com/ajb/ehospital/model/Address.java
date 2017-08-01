package com.ajb.ehospital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    public String address;
    public String zipCode;
    public String streetNumber;
    public String barangay;
    public String townDistrict;
    public String cityProvince;
    public String place;
    public String state;
    public String country;
}
