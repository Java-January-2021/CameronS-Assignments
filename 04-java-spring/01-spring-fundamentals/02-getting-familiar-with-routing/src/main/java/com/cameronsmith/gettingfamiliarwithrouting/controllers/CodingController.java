package com.cameronsmith.gettingfamiliarwithrouting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController
public class CodingController {
	@RequestMapping(value="/coding", method=RequestMethod.GET)
	public String str1() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping(value="/coding/python", method=RequestMethod.GET)
	public String str2() {
		return "Python/Django was awesome!";
	}
	@RequestMapping(value="/coding/java", method=RequestMethod.GET)
	public String str3() {
		return "Java/Spring is better!";
	}
}
