package com.cameronsmith.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class MainController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/{input}{input2}", method=RequestMethod.GET)
	public String name(@PathVariable("input") String input, @PathVariable("input2") String input2, Model viewModel) {
		viewModel.addAttribute("name", input);
		viewModel.addAttribute("lastName", input2);
		return "name.jsp";
	}
}