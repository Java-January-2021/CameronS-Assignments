package com.cameronsmith.gettingfamiliarwithrouting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller

public class DojoController {
	@RequestMapping(value="/dojo", method=RequestMethod.GET)
	public String dojo() {
		return "dojo.jsp";
	}
	@RequestMapping(value="/dojo/{campus}", method=RequestMethod.GET)
	public String dojo(@PathVariable("campus")String campus, Model viewModel ) {
		String temp = "burbank";
		String temp2 = "san-jose";
		String str2 = "";
		if(campus.equals(temp)) {
			str2 += "Burbank";
			viewModel.addAttribute("str2", str2);
			return "burbank.jsp";
		}
		else if(campus.equals(temp2)) {
			str2 += "SJ";
			viewModel.addAttribute("str2", str2);
			return "sj.jsp";
		}
		else {
			return dojo();
		}
	}
	
}
	
