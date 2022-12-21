package com.mehkey.URLShortening;

import com.mehkey.URLShortening.service.URLShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UrlShorteningApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShorteningApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialize(@Autowired URLShorteningService service) {
		return (String... args) -> service.initializeDatabase();
	}
}
