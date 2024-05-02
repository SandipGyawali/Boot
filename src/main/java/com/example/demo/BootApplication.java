package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Video;
import com.example.demo.repository.AuthorRepo;
import com.example.demo.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BootApplication {
	public static void main(String[] args) {
		var app = new SpringApplication(BootApplication.class);
		var context = app.run(args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
//					AuthorRepo authorRepo,
					VideoRepository videoRepository
	){
		return args -> {
//			var author = Author.builder()
//							.firstName("Sandip")
//							.lastName("Gyawali")
//							.email("sandip@gmail.com")
//							.build();
//
//			authorRepo.save(author);
			var video = Video.builder()
							.name("abc")
							.length(5)
							.build();
			videoRepository.save(video);
		};
	}
}
