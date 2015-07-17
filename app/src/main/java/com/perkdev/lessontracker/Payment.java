package com.perkdev.lessontracker;

import java.util.Date;

public class Payment {

	enum  PAYMENTTYPE {CASH, CHECK, OTHER};
	
	int id;
	
	double amount;
	
		
	PAYMENTTYPE type;
	
	Date date;
	
	String checkNum;
	String Notes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PAYMENTTYPE getType() {
		return type;
	}
	public void setType(PAYMENTTYPE type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	
}
