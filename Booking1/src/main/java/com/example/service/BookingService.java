package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Booking;

@Service
public interface BookingService {
	
	/**
     * Registers a new booking.
     * 
     * @param booking the booking details to be registered
     * @return the registered booking
     */
	
    Booking register(Booking booking);
    
    /**
     * Retrieves a booking by its ID.
     * 
     * @param id the ID of the booking to be retrieved
     * @return the booking details
     */
    
    Booking getBookingById(Long id);
    
    /**
     * Retrieves all bookings.
     * 
     * @return a list of all bookings
     */
    
    List<Booking> getAll();
    
    /**
     * Retrieves a booking by patient ID.
     * 
     * @param patientId the patient ID of the booking to be retrieved
     * @return the booking details
     */
    
    Booking getBookingByPatientId(Long patientId);
    
}