package com.cameronsmith.eventsbeltreviewer.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.eventsbeltreviewer.models.Event;
import com.cameronsmith.eventsbeltreviewer.models.Message;
import com.cameronsmith.eventsbeltreviewer.models.User;
import com.cameronsmith.eventsbeltreviewer.repositories.EventRepo;

@Service
public class EventService {
	@Autowired
	private EventRepo eRepo;
	
	public Event createEntry(Event newEntry) {
		return this.eRepo.save(newEntry);
	}
	public Event createEntry(String eventName, String eventLocation, String eventState, Date eventDate) {
		Event newEntry = new Event(eventName, eventLocation, eventState, eventDate);
		return this.eRepo.save(newEntry);
	}
	public Event updateEntry(Event toUpdate) {
		return this.eRepo.save(toUpdate);
	}
	public List<Event> getAll(){
		return this.eRepo.findAll();
	}
	public Event getEventById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.eRepo.deleteById(id);
	}
	public Event getByState(String eventState) {
		return this.eRepo.findByEventNameContaining(eventState);
	}
	public Event getByLocation(String eventLocation) {
		return this.eRepo.findByEventLocationContaining(eventLocation);
	}
	public Event getByName(String eventName) {
		return this.eRepo.findByEventNameContaining(eventName);
	}
	public List<User> getUsersAttending(){
		return this.getUsersAttending();
	}
	public void joinEvent(Event event, User user) {
		List<User> usersAttending = event.getUsersAttending();
		usersAttending.add(user);
		this.eRepo.save(event);
	}
	public void unJoinEvent(Event event, User user) {
		List<User> usersAttending = event.getUsersAttending();
		usersAttending.remove(user);
		this.eRepo.save(event);
	}
	public List<Message> getMessages(){
		return this.getMessages();
	}
	public List<Event> getEventsByUserState(String currentState){
		List<Event> inStateEvents = this.eRepo.findByEventState(currentState);
		return inStateEvents;
	}
	public List<Event> getOtherEventsByUserState(String currentState){
		List<Event> outStateEvents = this.eRepo.findByEventStateIsNot(currentState);
		return outStateEvents;
	}
	@SuppressWarnings("unused")
	public Integer getAttendeeCount(Event event) {
		Integer count = 0;
		List<User> attendees = event.getUsersAttending();
		for(User u:attendees) {
			count += 1;
		}
		return count;
	}
}
