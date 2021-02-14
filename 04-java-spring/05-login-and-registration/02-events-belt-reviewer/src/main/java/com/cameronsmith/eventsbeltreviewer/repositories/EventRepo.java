package com.cameronsmith.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.eventsbeltreviewer.models.Event;

public interface EventRepo extends CrudRepository<Event, Long>{
	List<Event> findAll();
	boolean existsByEventState(String state);
	Event findByEventStateContaining(String eventState);
	Event findByEventLocationContaining(String eventLocation);
	Event findByEventNameContaining(String eventName);
	
}
