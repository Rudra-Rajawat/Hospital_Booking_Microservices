package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Patient;
import com.example.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public Patient register(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).orElseThrow( () -> new RuntimeException("Patient not found"));
	}

}
