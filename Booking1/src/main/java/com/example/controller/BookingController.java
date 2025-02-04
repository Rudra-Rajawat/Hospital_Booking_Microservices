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

import com.example.entity.Booking;
import com.example.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/register")
	public ResponseEntity<Booking> register(@RequestBody Booking booking){
		return new ResponseEntity<>(bookingService.register(booking), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id){
		return ResponseEntity.ok(bookingService.getBookingById(id));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Booking>> getAll(){
		return ResponseEntity.ok(bookingService.getAll());
	}
}
