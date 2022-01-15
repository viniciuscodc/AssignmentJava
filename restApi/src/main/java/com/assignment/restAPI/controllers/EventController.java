package com.assignment.restAPI.controllers;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.restAPI.entity.Event;
import com.assignment.restAPI.entity.Payload;
import com.assignment.restAPI.services.EventService;
import com.assignment.restAPI.services.PayloadService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value="Rest Api")
@CrossOrigin(origins="*")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@Autowired
	PayloadService payloadService;
	
	@GetMapping("/events")
	public List<Event> getEvents() {
		
		List<Event> events = eventService.findAllEvents();
		
		return events;
	}
	
	@GetMapping("/event/{id}")
	public Event getEvent(@PathVariable(value="id") UUID eventId) {
		
		Event event = eventService.getEventById(eventId);
		
		return event;
	}
	
	@PostMapping("/event")
	public Event createEvent(@RequestBody Event event) {
		
		eventService.saveEvent(event);
		
		return event;
	}
	
	@DeleteMapping("/event/{id}")
	public String deleteEvent(@PathVariable(value="id") UUID eventId) {
		
		Event event = eventService.getEventById(eventId);
			
		if (event == null) {
			throw new RuntimeException("Event id not found - " + eventId);
		}
		
		eventService.deleteEventById(eventId);
		
		return "Deleted event id - " + eventId;
	}
	
	@PutMapping("/event")
	public Event updateEvent(@RequestBody Event event) {
		
		eventService.saveEvent(event);
		
		return event;
	}
	
	@PostMapping("/event/payload")
	public Payload createEvents(@RequestBody Payload payload) {
		
		payloadService.saveEvents(payload);

		return payload;
	}
}
