package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Hospital;
import com.example.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@Override
	public Hospital register(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@Override
	public Hospital getHospitalById(Long id) {
		return hospitalRepository.findById(id).orElseThrow( () -> new RuntimeException("hospital not found"));
	}

}
