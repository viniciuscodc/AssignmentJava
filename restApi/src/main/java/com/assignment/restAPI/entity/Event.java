package com.assignment.restAPI.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID eventId;
	
	private String transId;
	
	private String transTms;
	
	private int eventCnt;
	
	private String rcNum;
	
	private String clientId;
	
	private String locationCd;
	
	private String locationId1;
	
	private String locationId2;
	
	private String addrNbr;

	public UUID getEventId() {
		return eventId;
	}

	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}

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

	public int getEventCnt() {
		return eventCnt;
	}

	public void setEventCnt(int eventCnt) {
		this.eventCnt = eventCnt;
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

	public String getLocationCd() {
		return locationCd;
	}

	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}

	public String getLocationId1() {
		return locationId1;
	}

	public void setLocationId1(String locationId1) {
		this.locationId1 = locationId1;
	}

	public String getLocationId2() {
		return locationId2;
	}

	public void setLocationId2(String locationId2) {
		this.locationId2 = locationId2;
	}

	public String getAddrNbr() {
		return addrNbr;
	}

	public void setAddrNbr(String addrNbr) {
		this.addrNbr = addrNbr;
	}
}

