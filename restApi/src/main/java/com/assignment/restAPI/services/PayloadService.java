package com.assignment.restAPI.services;

import java.util.List;

import com.assignment.restAPI.entity.Event;
import com.assignment.restAPI.entity.Payload;

public interface PayloadService {
	
	public List<Event> savePayloadToEvents(Payload payload);
}
