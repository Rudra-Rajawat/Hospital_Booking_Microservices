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
import com.example.exception.HospitalNotFound;
import com.example.service.HospitalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    
    @Autowired
    HospitalService hospitalService;
   
    @PostMapping("/register")
    public ResponseEntity<Hospital> register(@RequestBody @Valid Hospital hospital){
        return new ResponseEntity<>(hospitalService.register(hospital), HttpStatus.OK);
    }
   
    @GetMapping("/getById/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable("id") Long id) throws HospitalNotFound{
        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }
}
