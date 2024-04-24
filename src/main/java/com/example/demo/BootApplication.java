package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {
	public static void main(String[] args) {
		var app = new SpringApplication(BootApplication.class);
		var context = app.run(args);
	}
}
