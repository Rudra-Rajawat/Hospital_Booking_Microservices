package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HospitalDTO is a Data Transfer Object that represents the hospital details.
 * It contains the ID, name, and address of the hospital.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HospitalDTO {
    
    /**
     * The unique identifier for the hospital.
     */
    private Long id;
    
    /**
     * The name of the hospital.
     */
    private String name;
    
    /**
     * The address of the hospital.
     */
    private String address;
}