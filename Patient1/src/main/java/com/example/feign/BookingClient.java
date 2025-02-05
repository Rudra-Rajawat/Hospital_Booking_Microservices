package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.BookingDTO;

/**
 * BookingClient is a Feign client interface for communicating with the Booking Service.
 * It provides a method to register a new booking.
 */
@FeignClient("BOOKING-SERVICE")
public interface BookingClient {
    
    /**
     * Registers a new booking with the Booking Service.
     * 
     * @param booking the booking details to be registered
     * @return ResponseEntity containing the registered booking
     */
    @PostMapping("/bookings/register")
    public ResponseEntity<BookingDTO> register(@RequestBody BookingDTO booking);
    
}