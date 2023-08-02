package com.example.inventoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InventoryApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryApiApplication.class, args);
	}
}
