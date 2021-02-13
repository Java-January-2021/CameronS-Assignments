package com.cameronsmith.eventsbeltreviewer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cameronsmith.eventsbeltreviewer.models.User;

@Controller
public class MasterController {
	@GetMapping("/")
	public String index(@ModelAttribute("user")User user) {
		return "index.jsp";
	}
}
