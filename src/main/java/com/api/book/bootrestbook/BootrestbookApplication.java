package com.api.book.bootrestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootrestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootrestbookApplication.class, args);
		System.out.println("Spring Boot Book API Application Started Successfully!");
		System.out.println("API Documentation: http://localhost:8080");
	}

}
