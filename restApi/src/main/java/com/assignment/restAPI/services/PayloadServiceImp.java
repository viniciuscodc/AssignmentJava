package com.assignment.restAPI.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.restAPI.dao.PayloadDAO;
import com.assignment.restAPI.entity.Event;
import com.assignment.restAPI.entity.Payload;
import com.assignment.restAPI.entity.Record;

@Service
public class PayloadServiceImp implements PayloadService {
	
	@Autowired
	private PayloadDAO payloadDAO;
	
	@Override
	@Transactional
	public List<Event> savePayloadToEvents(Payload payload) {
		
		// Should I use a mapper?
		List<Record> records = payload.getRecords();
		
		List<Event> events = new ArrayList();
		
		for(Record record : records){
					
			record.getEvent().parallelStream().forEach(recordEv -> {
			
			recordEv.setTransId(record.getTransId());
			recordEv.setTransTms(record.getTransTms());
			
			events.add(recordEv);
			});		
		}
		
		// Database save can't be parallel
		payloadDAO.saveEvents(events); 
		
		return events;
	}
}
