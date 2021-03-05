package com.example.project;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class YgApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(YgApp1Application.class, args);
	}

}
