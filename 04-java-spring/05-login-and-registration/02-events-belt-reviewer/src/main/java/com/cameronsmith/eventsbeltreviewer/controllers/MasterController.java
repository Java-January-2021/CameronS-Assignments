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
	@Autowired
	private MessageService mService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String loginAndReg(@ModelAttribute("user")User user) {
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
		return "redirect:/events";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credantials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/events";
	}
	@GetMapping("/events")
	public String allEvents(@ModelAttribute("event")Event event, HttpSession session, Model viewModel) {
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
		return "displayAll.jsp";
	}
	@PostMapping("/events/new")
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
			return "displayAll.jsp";
		}
		this.eService.createEntry(eventInput);
		return "redirect:/events";
	}
	@GetMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id")Long eventid, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Event eventToJoin = this.eService.getEventById(eventid);
		this.eService.joinEvent(eventToJoin, currentUser);
		return "redirect:/events";
	}
	@GetMapping("/events/{id}/unjoin")
	public String unJoinEvent(@PathVariable("id")Long eventId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Event eventToJoin = this.eService.getEventById(eventId);
		this.eService.unJoinEvent(eventToJoin, currentUser);
		return "redirect:/events";
	}
	@GetMapping("/events/{id}/delete")
	public String deleteEvent(@PathVariable("id")Long eventId) {
		this.eService.deleteById(eventId);
		return "redirect:/events";
	}
	@GetMapping("/events/{id}/edit")
	public String editEvent(@ModelAttribute("event")Event eventInput, @PathVariable("id")Long eventId, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Event eventToEdit = this.eService.getEventById(eventId);
		if(userId.equals(eventToEdit.getHost().getId())) {
			viewModel.addAttribute("event", eventToEdit);
			viewModel.addAttribute("currentUser", currentUser);
			return "edit.jsp";
		}
		return "redirect:/events";
	}
//	@PostMapping("/events/{id}/edit")
//	public String updateEvent(@RequestParam("host")User host, @RequestParam("eventName")String name, @RequestParam("eventLocation")String location, @RequestParam("eventDate")Date date,  @RequestParam("eventState")String state, @PathVariable("id")Long eventId, HttpSession session, Model viewModel) {
//		Event eventToEdit = this.eService.getEventById(eventId);
//		viewModel.addAttribute("event", eventToEdit);
//		eventToEdit.setHost(host);
//		eventToEdit.setEventName(name);
//		eventToEdit.setEventLocation(location);
//		eventToEdit.setEventDate(date);
//		eventToEdit.setEventState(state);
//		this.eService.updateEntry(eventToEdit);
//		return "redirect:/events";
//	}
	@PostMapping("/events/{id}/edit")
	public String updateEvent(@Valid @ModelAttribute("event")Event eventInput, BindingResult result, @PathVariable("id")Long eventId, HttpSession session, Model viewModel) {
		Event eventToEdit = this.eService.getEventById(eventId);
		viewModel.addAttribute("event", eventToEdit);
		if (result.hasErrors()) {
			viewModel.addAttribute("event", eventToEdit);
			return "edit.jsp";
		}
		this.eService.updateEntry(eventInput);
		return "redirect:/events";
	}
	@GetMapping("/events/{id}")
	public String eventInfo(@PathVariable("id")Long id, Model viewModel, HttpSession session) {
		Event thisEvent = this.eService.getEventById(id);
		viewModel.addAttribute("event", thisEvent);
		List<User> attendees = thisEvent.getUsersAttending();
		viewModel.addAttribute("attendees", attendees);
		Integer attendeeCount = this.eService.getAttendeeCount(thisEvent);
		viewModel.addAttribute("aCount", attendeeCount);
		List<Message> messages = thisEvent.getEventMessages();
		viewModel.addAttribute("messages", messages);
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		return "show.jsp";
	}
	@PostMapping("/events/{id}")
	public String addMessage(@RequestParam("event")Event event, @RequestParam("host")User host, @RequestParam("messageContent")String messageInput, @PathVariable("id")Long eventId) {
		Message newMessage = new Message();
		newMessage.setEvent(event);
		newMessage.setUser(host);
		newMessage.setMessageContent(messageInput);
		this.mService.createEntry(newMessage);
		return "redirect:/events/"+eventId;
	}
	@GetMapping("/logOutUser")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
