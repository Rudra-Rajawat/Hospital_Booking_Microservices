package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepartmentDTO {
//	private Long id;
//	private String name;
	
	@NotNull(message = "Department Id cannot be null")
    @Min(value = 1, message = "Department Id must be greater than or equal to 1")
	private Long id;
	
	@NotBlank(message = "Enter a valid Department name")
    @Size(min = 2, max = 50, message = "Department name must be between 2 and 50 characters")
	private String name;
}
