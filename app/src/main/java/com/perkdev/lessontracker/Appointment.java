package com.perkdev.lessontracker;

import java.util.Date;


public class Appointment {

	enum STATUS {COMPLETE, CANCELLED, RESCHEDULED};
	
	int id;
	
	Date date;
	Date startTime;
	Date endTime;
	
	STATUS status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	
	

	
}
