package com.cameronsmith.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
//@RequestMapping("/m")
public class HomeController {
	private String assignmentForms = "0345";
	private String assignmentBinary = "2342";
	private String lessonSetUp = "0733";
	private String lessonPunchCards = "0342";
	private String lessonAdvFortran = "0348";
	
	@RequestMapping(value ="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/m/{chapter}/0483/{assignmentNumber}", method=RequestMethod.GET)
	public String renderAssignment(@PathVariable("chapter") String discard, @PathVariable("assignmentNumber") String assignmentNum, Model viewModel) {
		if(assignmentNum.equals(assignmentForms)) {
			String bodyFill= "The goal of this assignment is to practice...Coding Forms";
			viewModel.addAttribute("filler",bodyFill);
			return "assignment.jsp";
		}
		else if(assignmentNum.equals(assignmentBinary)) {
			String bodyFill= "The goal of this assignment is to practice...Fortran to Binary";
			viewModel.addAttribute("filler",bodyFill);
			return "assignment.jsp";
		}
		return "index.jsp";
	}
	@RequestMapping(value="/m/{chapter}/0553/{lessonNumber}", method=RequestMethod.GET)
	public String renderLesson(@PathVariable("chapter") String discard, @PathVariable("lessonNumber") String lessonNumber, Model viewModel) {
		if(lessonNumber.equals(lessonSetUp)) {
			String bodyFill= "Setting up your servers Intro placeholder...";
			viewModel.addAttribute("filler",bodyFill);
			return "lesson.jsp";
		}
		else if(lessonNumber.equals(lessonPunchCards)) {
			String bodyFill= "Punch Cards Intro placeholder...";
			viewModel.addAttribute("filler",bodyFill);
			return "lesson.jsp";
		}
		else if(lessonNumber.equals(lessonAdvFortran)) {
			String bodyFill= "Advanced Fortran Intro placeholder...";
			viewModel.addAttribute("filler",bodyFill);
			return "lesson.jsp";
		}
		return "index.jsp";
	}
}
