package com.cameronsmith.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private Boolean langPreferance(String input) {
		return input.equals("Java");
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="username") String username, @RequestParam(value="locationInput") String location, @RequestParam(value="languageInput") String language, @RequestParam(value="commentInput") String comment, HttpSession session) {
		if(langPreferance(language)) {
			session.setAttribute("username", username);
			return "redirect:/java";
		}
		session.setAttribute("username", username);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "redirect:/results";
	}
	@RequestMapping(value="/results", method=RequestMethod.GET)
	public String results(HttpSession session, Model viewModel) {
		String username = (String) session.getAttribute("username");
		String location = (String) session.getAttribute("location");
		String language = (String) session.getAttribute("language");
		String comment = (String) session.getAttribute("comment");
		 viewModel.addAttribute("username", username);
		 viewModel.addAttribute("location", location);
		 viewModel.addAttribute("language", language);
		 viewModel.addAttribute("comment", comment);
		return "/results.jsp";
	}
	@RequestMapping("/java")
	public String java(HttpSession session, Model viewModel) {
		String username = (String) session.getAttribute("username");
		viewModel.addAttribute("username", username);
		return "javaRocks.jsp";
	}
}
