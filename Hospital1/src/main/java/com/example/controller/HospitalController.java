package com.example.controller;

import java.util.List;

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

/**
 * HospitalController is a REST controller that handles HTTP requests related to hospitals.
 * It provides endpoints to register a new hospital and retrieve hospital details by ID.
 */
@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    
    @Autowired
    HospitalService hospitalService;
    
    /**
     * Registers a new hospital.
     * 
     * @param hospital the hospital details to be registered
     * @return ResponseEntity containing the registered hospital and HTTP status OK
     */
    @PostMapping("/register")
    public ResponseEntity<Hospital> register(@RequestBody Hospital hospital){
        return new ResponseEntity<>(hospitalService.register(hospital), HttpStatus.OK);
    }
    
    /**
     * Retrieves a hospital by its ID.
     * 
     * @param id the ID of the hospital to be retrieved
     * @return ResponseEntity containing the hospital details and HTTP status OK
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") Long id){
        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }
}
