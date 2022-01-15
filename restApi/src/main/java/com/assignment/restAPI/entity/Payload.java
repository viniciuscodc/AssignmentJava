package com.assignment.restAPI.entity;

import java.io.Serializable;
import java.util.UUID;
import java.util.List;

public class Payload implements Serializable {
	
	private UUID batchId;
	
	private List<Record> records;
	
	public UUID getBatchId() {
		return batchId;
	}

	public void setBatchId(UUID batchId) {
		this.batchId = batchId;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}
}
