package com.wishes.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Component
@SpringBootApplication
public class WishesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WishesApplication.class, args);
	}

}
