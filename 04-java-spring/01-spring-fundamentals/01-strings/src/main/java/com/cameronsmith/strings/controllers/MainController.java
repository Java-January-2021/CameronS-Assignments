package com.cameronsmith.strings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@Controller
public class MainController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
        return "Hello World! How are you doing?";
	}
	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public String random() {
        return "Spring Boot is great! So easy to just respond with strings!";
	}
}
