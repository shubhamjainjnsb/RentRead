package com.rentRead.rentalSystem;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan("com.rentRead.rentalSystem.model")
public class RentalSystemApplication {	

	public static void main(String[] args) {
		SpringApplication.run(RentalSystemApplication.class, args);
	}
}
