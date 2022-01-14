package com.assignment.restAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.restAPI.controllers.EventController;
import com.assignment.restAPI.entity.Event;
import com.assignment.restAPI.services.EventService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class RestApiApplicationTests {
	
	@InjectMocks
	EventController eventController;
	
	Event event;

	@Mock
	private EventService repo;
	
	private UUID id = UUID.randomUUID();
	
	@BeforeEach
	void setUp() throws Exception {
		
		event = new Event();
		
		event.setEventId(id);
		event.setAddrNbr("test");
		event.setClientId("test");
		event.setEventCnt(0);
		event.setLocationCd("test");
		event.setLocationId1("test");
		event.setLocationId2("test");
		event.setRcNum("test");
		event.setTransId("test");
		event.setTransTms("test");	
	}
	
	@Test
	public void testCreateEvent() {
		
		doNothing().when(repo).saveEvent(event);
		
		Event result = eventController.createEvent(event);
		
		assertNotNull(result);	
	}
	
	@Test
	public void testGetEvent() {
		
		when(repo.getEventById(any(UUID.class))).thenReturn(event);
		
		Event result = eventController.getEvent(this.id);
		
		assertNotNull(result);
		assertEquals(result.getEventId(), this.id);
	}
	
	@Test
	public void testGetEvents() {
		
		List<Event> events = new ArrayList<>();
		events.add(event);
		
		when(repo.findAllEvents()).thenReturn(events);
		
		List<Event> result = eventController.getEvents();
			
		assertNotNull(result);
		assertEquals(result.get(0), event);
	}
	
	@Test
	public void testUpdateEvent() {
		
		when(repo.getEventById(any(UUID.class))).thenReturn(event);
		
		Event result = eventController.updateEvent(event);
		
		result.setAddrNbr("test2");
		
		assertEquals(result.getAddrNbr(), "test2");	
	}
	
	@Test
	public void testDeleteEvent() {
		
		when(repo.getEventById(any(UUID.class))).thenReturn(event);
		
		String result = eventController.deleteEvent(id);
		
		assertEquals(result, "Deleted event id - " + id);	
	}
}
