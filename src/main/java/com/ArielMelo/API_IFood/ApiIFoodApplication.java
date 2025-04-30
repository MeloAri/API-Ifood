package com.ArielMelo.API_IFood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ArielMelo.API_IFood.websocket")
public class ApiIFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiIFoodApplication.class, args);
	}

}
