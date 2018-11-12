package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
		System.out.println(new Pbkdf2PasswordEncoder().encode("techma"));
	}
}
