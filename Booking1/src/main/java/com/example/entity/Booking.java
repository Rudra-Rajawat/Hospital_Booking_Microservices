package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
