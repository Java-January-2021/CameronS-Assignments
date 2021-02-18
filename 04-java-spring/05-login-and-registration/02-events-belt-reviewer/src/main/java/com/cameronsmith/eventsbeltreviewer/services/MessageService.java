package com.cameronsmith.eventsbeltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.eventsbeltreviewer.models.Event;
import com.cameronsmith.eventsbeltreviewer.models.Message;
import com.cameronsmith.eventsbeltreviewer.models.User;
import com.cameronsmith.eventsbeltreviewer.repositories.MessageRepo;

@Service
public class MessageService {
	@Autowired
	private MessageRepo mRepo;
	
	public Message createEntry(Message newEntry) {
		return this.mRepo.save(newEntry);
	}
	public List<Message> getAll(){
		return this.mRepo.findAll();
	}
	public Message getMessageById(Long id) {
		return this.mRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.mRepo.deleteById(id);
	}
	public User getMessageCreator(Long id) {
		return this.getMessageById(id).getUser();
	}
	public Event getMessageEvent(Long id) {
		return this.getMessageById(id).getEvent();
	}
}
