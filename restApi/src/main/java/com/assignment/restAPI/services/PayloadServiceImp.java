package com.assignment.restAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.restAPI.dao.EventDAO;
import com.assignment.restAPI.entity.Payload;
import com.assignment.restAPI.entity.Record;

@Service
public class PayloadServiceImp implements PayloadService {
	
	@Autowired
	private EventDAO eventDAO;
	
	@Override
	@Transactional
	public void saveEvents(Payload payload) {
		
		// Should I use a mapper?
		List<Record> records = payload.getRecords();
		
		for(Record record : records){
			
			record.getEvent().parallelStream().forEach(recordEv -> {
				
				recordEv.setTransId(record.getTransId());
				recordEv.setTransTms(record.getTransTms());
				
				eventDAO.saveEvent(recordEv); 
			});
        }
	}
}
