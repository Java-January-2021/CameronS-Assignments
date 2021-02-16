package com.cameronsmith.eventsbeltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import com.cameronsmith.eventsbeltreviewer.models.Event;
import com.cameronsmith.eventsbeltreviewer.models.Message;
import com.cameronsmith.eventsbeltreviewer.models.User;
import com.cameronsmith.eventsbeltreviewer.services.EventService;
import com.cameronsmith.eventsbeltreviewer.services.MessageService;
import com.cameronsmith.eventsbeltreviewer.services.UserService;
import com.cameronsmith.eventsbeltreviewer.validators.UserValidator;

@Controller
public class MasterController {
	@Autowired
	private UserService uService;
	@Autowired
	private EventService eService;
	@SuppressWarnings("unused")
	@Autowired
	private MessageService mService;
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
		return "redirect:/wall";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credantials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/wall";
	}
	@GetMapping("/wall")
	public String wall(@ModelAttribute("event")Event event, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		User currentUser = this.uService.getById(userId);
		String currentState = currentUser.getState();
		List<Event> inStateEvents = this.eService.getEventsByUserState(currentState);
		List<Event> otherStateEvents = this.eService.getOtherEventsByUserState(currentState);
		viewModel.addAttribute("currentUser", currentUser);
		viewModel.addAttribute("inStateEvents", inStateEvents);
		viewModel.addAttribute("otherStateEvents", otherStateEvents);
		return "wallDisplay.jsp";
	}
	@GetMapping("/logOutUser")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@PostMapping("/add")
	public String newEvent(@Valid @ModelAttribute("event")Event eventInput, BindingResult result, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		String currentState = currentUser.getState();
		List<Event> inStateEvents = this.eService.getEventsByUserState(currentState);
		List<Event> otherStateEvents = this.eService.getOtherEventsByUserState(currentState);
		viewModel.addAttribute("currentUser", currentUser);
		viewModel.addAttribute("inStateEvents", inStateEvents);
		viewModel.addAttribute("otherStateEvents", otherStateEvents);
		if (result.hasErrors()) {
			return "wallDisplay.jsp";
		}
		this.eService.createEntry(eventInput);
		return "redirect:/wall";
	}
	@GetMapping("/{id}/info")
	public String eventInfo(@ModelAttribute("message")Message messageInput, @PathVariable("id")Long id, Model viewModel, HttpSession session) {
		Event thisEvent = this.eService.getEventById(id);
		viewModel.addAttribute("event", thisEvent);
		List<User> attendees = thisEvent.getUsersAttending();
		viewModel.addAttribute("attendees", attendees);
		Integer attendeeCount = this.eService.getAttendeeCount(thisEvent);
		viewModel.addAttribute("aCount", attendeeCount);
		List<Message> messages = thisEvent.getEventMessages();
		viewModel.addAttribute("eventMessages", messages);
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		return "show.jsp";
	}
	@PostMapping("/addMessage/{id}")
	public String addMessage(@ModelAttribute("message")Message messageInput, @PathVariable("id")Long id) {
		this.mService.createEntry(messageInput);
		return "redirect:/"+id+"/info";
	}
	@GetMapping("/joinEvent/{id}")
	public String joinEvent(@PathVariable("id")Long eventid, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Event eventToJoin = this.eService.getEventById(eventid);
		this.eService.joinEvent(eventToJoin, currentUser);
		return "redirect:/wall";
	}
	@GetMapping("/unJoinEvent/{id}")
	public String unJoinEvent(@PathVariable("id")Long eventId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Event eventToJoin = this.eService.getEventById(eventId);
		this.eService.unJoinEvent(eventToJoin, currentUser);
		return "redirect:/wall";
	}
	@GetMapping("/{id}/delete")
	public String deleteEvent(@PathVariable("id")Long eventId) {
		this.eService.deleteById(eventId);
		return "redirect:/wall";
	}
	@GetMapping("/{id}/edit")
	public String editEvent(@PathVariable("id")Long eventId, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Event eventToEdit = this.eService.getEventById(eventId);
		if(userId.equals(eventToEdit.getUser().getId())) {
			viewModel.addAttribute("event", eventToEdit);
			return "edit.jsp";
		}
		return "redirect:/wall";
	}
	@PostMapping("/{id}/edit")
	public String updateEvent(@Valid @ModelAttribute("event")Event eventUpdate, BindingResult result, @PathVariable("id")Long eventId,HttpSession session, Model viewModel) {
		Event eventToEdit = this.eService.getEventById(eventId);
		if (result.hasErrors()) {
			viewModel.addAttribute("event", eventToEdit);
			return "edit.jsp";
		}
		this.eService.updateEntry(eventUpdate);
		return "redirect:/wall";
	}
}
