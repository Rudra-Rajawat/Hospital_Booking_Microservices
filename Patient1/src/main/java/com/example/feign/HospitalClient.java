package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.HospitalDTO;

@FeignClient("HOSPITAL-SERVICE")
public interface HospitalClient {
	@GetMapping("/hospitals/getById/{id}")
	public ResponseEntity<HospitalDTO> getHospitalById(@PathVariable("id") Long id);
}
