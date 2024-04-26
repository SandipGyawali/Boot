package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.repository.AuthorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootApplication {
	public static void main(String[] args) {
		var app = new SpringApplication(BootApplication.class);
		var context = app.run(args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(AuthorRepo authorRepo){
//		return args -> {
//			var author = Author.builder()
//							.firstName("Sandip")
//							.lastName("Gyawali")
//							.email("sandip@gmail.com")
//							.build();
//
//			authorRepo.save(author);
//		};
//	}
}
