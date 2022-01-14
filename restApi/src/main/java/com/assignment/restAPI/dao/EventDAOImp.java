package com.assignment.restAPI.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assignment.restAPI.entity.Event;

@Repository
public class EventDAOImp implements EventDAO  {
		
		private EntityManager entityManager;
		
		@Autowired
		public EventDAOImp(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
		@Override
		public List<Event> findAllEvents() {
			
			Session currentSession = entityManager.unwrap(Session.class);
			
			Query<Event> theQuery = currentSession.createQuery("from Event", Event.class);
			
			List<Event> events = theQuery.getResultList();
					
			return events;			
		}
		
		@Override
		public void saveEvent(Event event) {
			
			Session currentSession = entityManager.unwrap(Session.class);
			
			currentSession.saveOrUpdate(event);
		}
		
		@Override
		public Event getEventById(UUID id) {
			
			Session currentSession = entityManager.unwrap(Session.class);
			
			Event event = currentSession.get(Event.class, id);
			
			return event;
		}
		
		@Override
		public void deleteEventById(UUID id) {

			Session currentSession = entityManager.unwrap(Session.class);
			
			Query query = currentSession.createQuery("delete from Event where eventId=:id");
			query.setParameter("id", id);
			
			query.executeUpdate();	
		}
}


