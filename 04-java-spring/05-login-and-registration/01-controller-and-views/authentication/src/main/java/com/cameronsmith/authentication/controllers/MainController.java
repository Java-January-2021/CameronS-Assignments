package com.cameronsmith.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameronsmith.authentication.models.User;
import com.cameronsmith.authentication.services.UserService;
import com.cameronsmith.authentication.validators.UserValidator;

@Controller
public class MainController {
	@Autowired 
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("user")User user) {
		return "index.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credantials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		System.out.println(this.uService.getByEmail(email));
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("user", currentUser);
		return "welcome.jsp";
	}
	@GetMapping("/logOutUser")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}

