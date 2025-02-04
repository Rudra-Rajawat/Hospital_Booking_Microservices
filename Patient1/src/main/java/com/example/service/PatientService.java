package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Patient;

@Service
public interface PatientService{
	Patient register (Patient patient);
	Patient getPatientById (Long id);
}
