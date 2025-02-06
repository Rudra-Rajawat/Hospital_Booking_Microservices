package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.entity.Hospital;

/**
 * HospitalService is a service interface that defines methods for managing hospital entities.
 * It provides methods to register a new hospital and retrieve hospital details by ID.
 */

@Service
public interface HospitalService {
    
    /**
     * Registers a new hospital.
     * 
     * @param hospital the hospital details to be registered
     * @return the registered hospital
     */
    Hospital register(Hospital hospital);
    
    /**
     * Retrieves a hospital by its ID.
     * 
     * @param id the ID of the hospital to be retrieved
     * @return the hospital details
     */
    Hospital getHospitalById(Long id);
    
    List<Hospital> getAllHospitals();
}
