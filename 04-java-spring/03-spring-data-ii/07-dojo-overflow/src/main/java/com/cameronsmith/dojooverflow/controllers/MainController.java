package com.cameronsmith.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameronsmith.dojooverflow.models.Question;
import com.cameronsmith.dojooverflow.models.Tag;
import com.cameronsmith.dojooverflow.services.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService mService;
	@GetMapping("/")
	public String login() {
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		List<Question> allQuestions = mService.getAllQuestions();
		//Access indivudual tag object	 subjects
		
		viewModel.addAttribute("allQuestions", allQuestions);
		return "allQuestions.jsp";
	}
	@GetMapping("/questions/new")
	public String newQuestion() {
		
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String addQuestion(@RequestParam("question")String questionInput,@RequestParam("tags")String tagsInput, RedirectAttributes redirectAttr) {
		//take tagsInput and split into single strings and add to ArrayList
		ArrayList<Tag>tagsOutput = this.mService.splitTagString(tagsInput);
		System.out.println(tagsOutput);
		//Validations NotEmpty
		//Need Validations for max=3, comma separated and lower case
		ArrayList<String> errors = new ArrayList<String>();
		if(questionInput.equals("")) {
			errors.add("Question cannot be blank.");
		}
		if(tagsInput.equals("")) {
			errors.add("Tags cannot be blank.");
		}
		if(errors.size() > 0) {
			for(String e: errors){
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/questions/new";
		}
		//
		//Create Question object with private tag list
		this.mService.createQuestion(questionInput, tagsOutput);
		return "redirect:/dashboard";
	}
}
