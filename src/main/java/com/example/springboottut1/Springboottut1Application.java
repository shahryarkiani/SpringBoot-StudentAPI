package com.example.springboottut1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Springboottut1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboottut1Application.class, args);
	}

	@GetMapping
	public String hello() {
		return "Hello World";
	}

}
