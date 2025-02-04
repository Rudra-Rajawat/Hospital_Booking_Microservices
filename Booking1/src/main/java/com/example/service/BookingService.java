package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Booking;

@Service
public interface BookingService {
	Booking register(Booking booking);
	Booking getBookingById(Long id);
	List<Booking> getAll();
}
