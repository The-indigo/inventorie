package com.ajdeyemi.inventorie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventorieApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorieApplication.class, args);
		System.out.println("Inventory Backend started");
	}

}
