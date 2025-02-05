package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Booking;
import com.example.repository.BookingRepository;

/**
 * BookingServiceImpl is a service class that implements the BookingService interface.
 * It provides methods to register a new booking, retrieve bookings by ID, retrieve all bookings,
 * and retrieve bookings by patient ID.
 */
@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;
    
    /**
     * Registers a new booking.
     * 
     * @param booking the booking details to be registered
     * @return the registered booking
     */
    @Override
    public Booking register(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Retrieves a booking by its ID.
     * 
     * @param id the ID of the booking to be retrieved
     * @return the booking details
     * @throws RuntimeException if no booking is found with the given ID
     */
    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("No booking found")); 
    }

    /**
     * Retrieves all bookings.
     * 
     * @return a list of all bookings
     */
    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    /**
     * Retrieves a booking by patient ID.
     * 
     * @param patientId the patient ID of the booking to be retrieved
     * @return the booking details
     * @throws RuntimeException if no booking is found with the given patient ID
     */
    @Override
    public Booking getBookingByPatientId(Long patientId) {
        return bookingRepository.findById(patientId).orElseThrow(() -> new RuntimeException("No Patient found")); 
    }
}