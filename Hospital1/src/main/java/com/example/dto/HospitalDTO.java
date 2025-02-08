package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HospitalDTO is a Data Transfer Object that represents the hospital details.
 * It contains the ID, name, and address of the hospital.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HospitalDTO {
	
	private Long id;
	private String name;
	private String address;
}