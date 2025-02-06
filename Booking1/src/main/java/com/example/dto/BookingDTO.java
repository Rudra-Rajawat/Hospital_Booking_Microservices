package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	private Long id;
	private Long patientId;
	private String patientName;
	private int patientAge;
	private String patientGender;
	private Long hopspitalId;
	private String hopspitalName;
	private String hopspitalAddress;
	private Long departmentId;
	private String departmentName;
	private String status;
}
