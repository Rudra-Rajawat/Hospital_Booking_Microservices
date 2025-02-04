package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Patient1Application {

	public static void main(String[] args) {
		SpringApplication.run(Patient1Application.class, args);
	}

}
