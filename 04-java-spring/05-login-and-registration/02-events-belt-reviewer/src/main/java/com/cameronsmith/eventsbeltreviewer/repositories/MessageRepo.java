package com.cameronsmith.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.eventsbeltreviewer.models.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {
	List<Message> findAll();
	boolean existsById(Long id);
	Message findByMessageContent(String email);
}
