package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	/*
	If you want to execute a different application.properties on the start of the app
	you need to use --spring.config.location={file location} as run parameter.
	Otherwise, app is going to use resources/application.properties.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping
	public String intro() {
		return "Hello World.";
	}
}
