package com.assignment.restAPI.dao;
import com.assignment.restAPI.entity.Event;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PayloadDAOImp implements PayloadDAO  {
		
	private EntityManager entityManager;
	
	@Autowired
	public PayloadDAOImp(EntityManager _EntityManager) {
		entityManager = _EntityManager;
	}
	
	@Override
	public void saveEvents(List<Event> events) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		for(Event event : events){ 
			currentSession.saveOrUpdate(event);
		}	
	}
}



