package com.cameronsmith.displaydate.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/date", method=RequestMethod.GET)
	public String date(Model viewModel) {
		Date date = new Date();
		String pattern = "EEEEE,' the 'dd ' of ' MMMMM, yyyy";
		SimpleDateFormat dateOnly = new SimpleDateFormat(pattern);
		String dateInput = dateOnly.format(date);
		viewModel.addAttribute("date", dateInput);
		return "date.jsp";
	}
	@RequestMapping(value="/time", method=RequestMethod.GET)
	public String time(Model viewModel) {
		Date date = new Date();
		System.out.println(date);
		String pattern = "h:mm a";
		SimpleDateFormat timeOnly = new SimpleDateFormat(pattern);
		String timeInput = timeOnly.format(date);
		viewModel.addAttribute("timeNow", timeInput);
		return "time.jsp";
	}
}
