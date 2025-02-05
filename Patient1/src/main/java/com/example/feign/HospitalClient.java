package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.HospitalDTO;

/**
 * HospitalClient is a Feign client interface for communicating with the Hospital Service.
 * It provides a method to retrieve hospital details by ID.
 */
@FeignClient("HOSPITAL-SERVICE")
public interface HospitalClient {
    
    /**
     * Retrieves a hospital by its ID from the Hospital Service.
     * 
     * @param id the ID of the hospital to be retrieved
     * @return ResponseEntity containing the hospital details
     */
    @GetMapping("/hospitals/getById/{id}")
    public ResponseEntity<HospitalDTO> getHospitalById(@PathVariable("id") Long id);
}
