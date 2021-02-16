package com.cameronsmith.eventsbeltreviewer.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.eventsbeltreviewer.models.Event;
import com.cameronsmith.eventsbeltreviewer.models.Message;
import com.cameronsmith.eventsbeltreviewer.models.User;
import com.cameronsmith.eventsbeltreviewer.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo uRepo;
	
	public User registerUser(User newEntry) {
		String hash = BCrypt.hashpw(newEntry.getPassword(), BCrypt.gensalt());
		newEntry.setPassword(hash);
		return this.uRepo.save(newEntry);
	}
	public User createEntry(String email, String firstName, String lastName, String location, String state, String password, String confirmPassword) {
		User newEntry = new User(email, firstName, lastName, location, state, password,confirmPassword);
		String hash = BCrypt.hashpw(newEntry.getPassword(), BCrypt.gensalt());
		newEntry.setPassword(hash);
		return this.uRepo.save(newEntry);
	}
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}else if(user != null && user.getEmail().equals(email)){
			return BCrypt.checkpw(password, user.getPassword());
		}else {
		return false;
		}
	}
	public User updateEntry(User toUpdate) {
		return this.uRepo.save(toUpdate);
	}
	public List<User> getAll(){
		return this.uRepo.findAll();
	}
	public User getById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.uRepo.deleteById(id);
	}
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	public void addEventToAttend(Event event, User user) {
		List<Event> eventsToAttend = user.getEventsAttending();
		eventsToAttend.add(event);
		this.uRepo.save(user);
	}
	public void removeEventToAttend(Event event, User user) {
		List<Event> eventsAttending = user.getEventsAttending();
		eventsAttending.remove(event);
		this.uRepo.save(user);
	}
	public List<Event> getUserEAByUserId(Long id){
		List<Event> eventsAttending = this.getById(id).getEventsAttending();
		return eventsAttending;
	}
	public List<Event> getEventsCreated(){
		return this.getEventsCreated();
	}
	public List<Message> getMessagesCreated(){
		return this.getMessagesCreated();
	}
}
