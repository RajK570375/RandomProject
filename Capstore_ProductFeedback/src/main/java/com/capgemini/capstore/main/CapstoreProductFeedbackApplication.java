package com.capgemini.capstore.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.capgemini.capstore.main.beans")
public class CapstoreProductFeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstoreProductFeedbackApplication.class, args);
	}

}
