package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Hospital;

@Service
public interface HospitalService {
	Hospital register(Hospital hospital);
	Hospital getHospitalById(Long id);
}
