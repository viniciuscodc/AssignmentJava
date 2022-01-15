package com.assignment.restAPI.entity;

import java.util.List;

public class Record {
	
	private String transId;
	
	private String transTms;
	
	private String rcNum;
	
	private String clientId;
	
	// Should be events
	List<Event> event;
	
	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransTms() {
		return transTms;
	}

	public void setTransTms(String transTms) {
		this.transTms = transTms;
	}

	public String getRcNum() {
		return rcNum;
	}

	public void setRcNum(String rcNum) {
		this.rcNum = rcNum;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public List<Event> getEvent() {
		return event;
	}

	public void setEvent(List<Event> event) {
		this.event = event;
	}
}
