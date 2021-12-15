package com.example.backathena;

import com.example.backathena.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class BackathenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackathenaApplication.class, args);
	}

}
