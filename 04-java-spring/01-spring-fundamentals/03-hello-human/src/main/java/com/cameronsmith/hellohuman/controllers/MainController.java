package com.cameronsmith.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class MainController {
	@RequestMapping(value="/")
	public String index(Model viewModel) {
		String alt = "Human";
		viewModel.addAttribute("name", alt);
		return "name.jsp";
	}
	@RequestMapping(value="{input}")
	public String firstaName(@PathVariable("input") String input, Model viewModel) {
		viewModel.addAttribute("name", input);
		return "name.jsp";
	}
	@RequestMapping(value="{input}/{input2}")
	public String lastName(@PathVariable("input") String input, @PathVariable("input2") String input2, Model viewModel) {
		if (input.equals("") && input2.equals("")){
			String alt = "Muman";
			viewModel.addAttribute("name", alt);
		}
		viewModel.addAttribute("name", input);
		viewModel.addAttribute("lastName", input2);
		return "name.jsp";
	}
}