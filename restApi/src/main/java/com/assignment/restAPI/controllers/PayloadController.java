package com.assignment.restAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.restAPI.entity.Event;
import com.assignment.restAPI.entity.Payload;
import com.assignment.restAPI.services.PayloadService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value="Rest Api")
@CrossOrigin(origins="*")
public class PayloadController {
	
	@Autowired
	PayloadService payloadService;
	
	@PostMapping("/payload")
	public List<Event> createEvents(@RequestBody Payload payload) {
		
		List<Event> events = payloadService.savePayloadToEvents(payload);

		return events;
	}
}