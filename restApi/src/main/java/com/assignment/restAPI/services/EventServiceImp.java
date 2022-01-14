package com.assignment.restAPI.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.restAPI.dao.EventDAO;
import com.assignment.restAPI.entity.Event;

@Service
public class EventServiceImp implements EventService {
	
	@Autowired
	private EventDAO eventDAO;
	
	@Override
	@Transactional
	public List<Event> findAllEvents() {
		return eventDAO.findAllEvents();
	}

	@Override
	@Transactional
	public void saveEvent(Event event) {

		eventDAO.saveEvent(event);
	}
	
	@Override
	@Transactional
	public Event getEventById(UUID id) {
		
		return eventDAO.getEventById(id);
	}
	
	@Override
	@Transactional
	public void deleteEventById(UUID id) {
		
		eventDAO.deleteEventById(id);
	}
}
