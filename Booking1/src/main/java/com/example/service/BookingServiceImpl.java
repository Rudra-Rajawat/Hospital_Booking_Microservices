package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Booking;
import com.example.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public Booking register(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id).orElseThrow( () -> new RuntimeException("No booking found")); 
	}

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	
}
