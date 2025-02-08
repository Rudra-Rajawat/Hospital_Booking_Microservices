package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
//	private Long patientId;
//	private String patientName;
//	private int patientAge;
//	private String patientGender;
//	private Long hopspitalId;
//	private String hopspitalName;
//	private String hopspitalAddress;
//	private Long departmentId;
//	private String departmentName;
//	private String status;
	
	@NotNull(message = "Patient Id cannot be null")
    @Min(value = 1, message = "Patient Id must be greater than or equal to 1")
	private Long patientId;
	
	@NotBlank(message = "Enter a valid Patient name")
    @Size(min = 2, max = 50, message = "Patient name must be between 2 and 50 characters")
	private String patientName;
	
	@NotEmpty(message = "Patient Age cannot be empty")
    @Min(value = 1, message = "Patient Age must be greater than 0")
	private int patientAge;
	
	@NotBlank(message = "Enter a valid Patient Gender")
    @Size(min = 2, max = 50, message = "Patient Gender must be between 2 and 50 characters")
	private String patientGender;
	
	@NotNull(message = "Hospital Id cannot be null")
    @Min(value = 1, message = "Hospital Id must be greater than or equal to 1")
	private Long hospitalId;
	
	@NotBlank(message = "Enter a valid Hospital name")
    @Size(min = 2, max = 50, message = "Hospital name must be between 2 and 50 characters")
	private String hospitalName;
	
	@NotBlank(message = "Enter a valid Hospital Address")
    @Size(min = 2, max = 50, message = "Hospital Address must be between 2 and 50 characters")
	private String hospitalAddress;
	
	@NotNull(message = "Department Id cannot be null")
    @Min(value = 1, message = "Department Id must be greater than or equal to 1")
	private Long departmentId;
	
	@NotBlank(message = "Enter a valid Department name")
    @Size(min = 2, max = 50, message = "Department name must be between 2 and 50 characters")
	private String departmentName;
	
	@NotNull(message = "Status cannot be null")
	private String status;
}
