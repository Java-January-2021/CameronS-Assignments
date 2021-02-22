package com.cameronsmith.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameronsmith.dojooverflow.models.Answer;
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
		
		viewModel.addAttribute("allQuestions", allQuestions);
		return "allQuestions.jsp";
	}
	@GetMapping("/questions/new")
	public String newQuestion() {
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/new")
	public String addQuestion(@RequestParam("question") String questionInput, @RequestParam("tags") String tagsInput, RedirectAttributes redirectAttr) {
		//Validations NotEmpty,  max=3 tags, 
		//Need Validations for comma separated and lower case
		ArrayList<String> errors = new ArrayList<String>();
		ArrayList<Tag>tagsOutput = this.mService.splitTagString(tagsInput.toLowerCase());
		if(questionInput.equals("")) {
			errors.add("Question cannot be blank.");
		}
		else if(tagsInput.equals("")) {
			errors.add("Tags cannot be blank.");
		}
		else if(tagsOutput.size()> 3) {
			errors.add("Cannot input more than 3 tags.");
		}
		if(errors.size() > 0) {
			for(String e: errors){
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/questions/new";
		}
		//take tagsInput and split into single strings and add to ArrayList
		ArrayList<Tag>tagsOutput1 = this.mService.splitTagString(tagsInput.toLowerCase());
		//System.out.println(tagsOutput);
		//Create Question object with private tag list
		this.mService.createQuestion(questionInput, tagsOutput1);
		return "redirect:/dashboard";
	}
	@GetMapping("/question/{id}")
	public String showQuestionInfo(@ModelAttribute("answerInput")Answer answerInput, @PathVariable("id")Long id, Model viewModel, BindingResult result) {
		Question thisQuestion = mService.getQuestionById(id);
		
		viewModel.addAttribute("question", thisQuestion);
		return "/showQuestion.jsp";
	}
	@PostMapping("/question/{id}")
	public String addAnswer(@Valid @ModelAttribute("answerInput")Answer answerInput, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		Question thisQuestion = mService.getQuestionById(id);
		viewModel.addAttribute("question", thisQuestion);
		if (result.hasErrors()) {
			return "/showQuestion.jsp";
		}
		Answer newAnswer = answerInput;
		this.mService.createAnswer(newAnswer.getAnswer(), thisQuestion);
		//this.mService.addAnswerToQuestion(answerInput, thisQuestion);
		return "redirect:/question/{id}";
	}
	@GetMapping("/{id}/delete")
	public String deleteObject(@PathVariable("id")Long id) {
		mService.deleteQuestionById(id);
		return "redirect:/dashboard";
	}
	
}
