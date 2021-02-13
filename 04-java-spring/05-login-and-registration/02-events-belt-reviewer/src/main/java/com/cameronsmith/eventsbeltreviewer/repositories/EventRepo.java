package com.cameronsmith.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.eventsbeltreviewer.models.Event;

public interface EventRepo extends CrudRepository<Event, Long>{
	List<Event> findAll();
	boolean existsByState(String state);
	Event findByStateContaining(String eventState);
	Event findByLocationContaining(String eventLocation);
	Event findByNameContaining(String eventName);
	
}
