package com.assignment.restAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.restAPI.controllers.PayloadController;
import com.assignment.restAPI.entity.Event;
import com.assignment.restAPI.entity.Payload;
import com.assignment.restAPI.services.PayloadService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PayloadControllerTests {
	
	@InjectMocks
	PayloadController payloadController;
	
	private Payload payload;
	private List<Event> events;
	private Event event;

	@Mock
	private PayloadService repo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		payload = new Payload();
		events = new ArrayList<Event>();
		event = new Event();
	}
	
	@Test
	public void createEventsTest() {
		
		when(repo.savePayloadToEvents(any(Payload.class))).thenReturn(events);
		
		List<Event> result = payloadController.createEvents(payload);
		
		result.add(event);
			
		assertNotNull(result);
		assertEquals(result, events);	
		assertTrue(result.size() > 0);
	}
}

