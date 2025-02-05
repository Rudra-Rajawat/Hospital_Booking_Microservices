package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Patient;
import com.example.repository.PatientRepository;

/**
 * PatientServiceImpl is a service class that implements the PatientService interface.
 * It provides methods to register a new patient and retrieve patient details by ID.
 */

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    
    /**
     * Registers a new patient.
     * 
     * @param patient the patient details to be registered
     * @return the registered patient
     */
    @Override
    public Patient register(Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     * Retrieves a patient by their ID.
     * 
     * @param id the ID of the patient to be retrieved
     * @return the patient details
     * @throws RuntimeException if no patient is found with the given ID
     */
    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}