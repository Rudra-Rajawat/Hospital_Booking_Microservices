package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Hospital;
import com.example.service.HospitalService;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/register")
	public ResponseEntity<Hospital> register(@RequestBody Hospital hospital){
		return new ResponseEntity<>(hospitalService.register(hospital), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") Long id){
		return ResponseEntity.ok(hospitalService.getHospitalById(id));
	}
}
