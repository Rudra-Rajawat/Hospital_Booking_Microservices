package com.example.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDTO {
	@NotNull(message = "Hospital Id cannot be null")
    @Min(value = 1, message = "Hospital Id must be greater than or equal to 1")
	private Long id;
	
	@NotBlank(message = "Enter a valid Hospital name")
    @Size(min = 2, max = 50, message = "Hospital name must be between 2 and 50 characters")
	private String name;
	
	@NotBlank(message = "Enter a valid Hospital Address")
    @Size(min = 2, max = 50, message = "Hospital Address must be between 2 and 50 characters")
	private String address;
}
