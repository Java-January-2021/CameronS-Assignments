package com.cameronsmith.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MasterController {
	private Boolean codeInput(String input) {
		return input.equals("bushido");
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
		return "index.jsp";
	}
	@RequestMapping(value="/inputForm", method=RequestMethod.POST)
	public String form(@RequestParam(value="input")String input, RedirectAttributes errors) {
		if(codeInput(input)) {
			return "redirect:/code";			
		}
		errors.addFlashAttribute("error", "That is not The Way");
		return "redirect:/";
	}
	@RequestMapping(value="/code", method=RequestMethod.GET)
	public String code() {
		return "code.jsp";
	}
}
