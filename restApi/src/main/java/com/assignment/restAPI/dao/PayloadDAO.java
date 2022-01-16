package com.assignment.restAPI.dao;

import java.util.List;

import com.assignment.restAPI.entity.Event;

public interface PayloadDAO {

	public void saveEvents(List<Event> events);
}
