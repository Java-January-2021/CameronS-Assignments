package com.cameronsmith.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.eventsbeltreviewer.models.Event;

public interface EventRepo extends CrudRepository<Event, Long>{
	List<Event> findAll();
	boolean existsByEventState(String state);
	List<Event> findByEventState(String currentState);
	List<Event> findByEventStateIsNot(String currentState);
	Event findByEventLocationContaining(String eventLocation);
	Event findByEventNameContaining(String eventName);
	
}
