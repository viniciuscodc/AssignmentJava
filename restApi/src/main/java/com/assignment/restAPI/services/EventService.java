package com.assignment.restAPI.services;

import java.util.List;
import java.util.UUID;

import com.assignment.restAPI.entity.Event;

public interface EventService {
	
	public List<Event> findAllEvents();
	
	public void saveEvent(Event event);
	
	public Event getEventById(UUID id);
	
	public void deleteEventById(UUID id);
}
