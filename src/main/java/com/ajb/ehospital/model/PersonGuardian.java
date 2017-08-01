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
public class PersonGuardian {
    private String guardianName;
    private String guardianAddress;
    private String guardianContactNumber;
}
