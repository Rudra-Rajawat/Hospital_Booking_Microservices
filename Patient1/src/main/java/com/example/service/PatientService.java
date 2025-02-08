package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Patient;
import com.example.exception.PatientNotFound;

/**
 * PatientService is a service interface that defines methods for managing patient entities.
 * It provides methods to register a new patient and retrieve patient details by ID.
 */
@Service
public interface PatientService {
    
    /**
     * Registers a new patient.
     * 
     * @param patient the patient details to be registered
     * @return the registered patient
     */
    Patient register(Patient patient);
    
    /**
     * Retrieves a patient by their ID.
     * 
     * @param id the ID of the patient to be retrieved
     * @return the patient details
     */
    Patient getPatientById(Long id) throws PatientNotFound;
    
    List<Patient> getAll();
}