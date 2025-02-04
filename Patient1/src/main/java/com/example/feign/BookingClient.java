package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.BookingDTO;

@FeignClient("BOOKING-SERVICE")
public interface BookingClient {
	
	@PostMapping("/bookings/register")
	public ResponseEntity<BookingDTO> register(@RequestBody BookingDTO booking);
	
}
