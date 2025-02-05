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

/**
 * BookingController is a REST controller that handles HTTP requests related to bookings.
 * It provides endpoints to register a new booking, retrieve bookings by ID, retrieve all bookings,
 * and retrieve bookings by patient ID.
 */
@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired
    BookingService bookingService;
    
    /**
     * Registers a new booking.
     * 
     * @param booking the booking details to be registered
     * @return ResponseEntity containing the registered booking and HTTP status OK
     */
    @PostMapping("/register")
    public ResponseEntity<Booking> register(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.register(booking), HttpStatus.OK);
    }
    
    /**
     * Retrieves a booking by its ID.
     * 
     * @param id the ID of the booking to be retrieved
     * @return ResponseEntity containing the booking details and HTTP status OK
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    
    /**
     * Retrieves all bookings.
     * 
     * @return ResponseEntity containing a list of all bookings and HTTP status OK
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Booking>> getAll(){
        return ResponseEntity.ok(bookingService.getAll());
    }
    
    /**
     * Retrieves a booking by patient ID.
     * 
     * @param pId the patient ID of the booking to be retrieved
     * @return ResponseEntity containing the booking details and HTTP status OK
     */
    @GetMapping("/getByPatientId/{pId}")
    public ResponseEntity<Booking> getByPatientId(@PathVariable("pId") Long pId){
        return ResponseEntity.ok(bookingService.getBookingByPatientId(pId));
    }
    
}