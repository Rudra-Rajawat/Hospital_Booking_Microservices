package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Hospital;
import com.example.repository.HospitalRepository;

/**
 * HospitalServiceImpl is a service class that implements the HospitalService interface.
 * It provides methods to register a new hospital and retrieve hospital details by ID.
 */
@Service
public class HospitalServiceImpl implements HospitalService{
    
    @Autowired
    HospitalRepository hospitalRepository;
    
    /**
     * Registers a new hospital.
     * 
     * @param hospital the hospital details to be registered
     * @return the registered hospital
     */
    @Override
    public Hospital register(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    /**
     * Retrieves a hospital by its ID.
     * 
     * @param id the ID of the hospital to be retrieved
     * @return the hospital details
     * @throws RuntimeException if no hospital is found with the given ID
     */
    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("hospital not found"));
    }

	@Override
	public List<Hospital> getAllHospitals() {
		return hospitalRepository.findAll();
	}

}
