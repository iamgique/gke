package com.iamgique.gke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@SpringBootApplication
@RestController
public class GkeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GkeApplication.class, args);
	}

	@GetMapping("hello/{name}")
	public String hello(@Valid @PathVariable("name") String name) {
		return "Hello " + name;
	}
}
