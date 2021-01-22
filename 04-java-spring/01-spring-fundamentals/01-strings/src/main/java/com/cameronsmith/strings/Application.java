package com.cameronsmith.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@RequestMapping("/")
	public String hello() {
        return "Hello World! How are you doing?";
	}
	@RequestMapping("/random")
	public String random() {
        return "Spring Boot is great! So easy to just respond with strings!";
	}

}
