package com.kattyolv.prime.pizza.api.model;

import com.kattyolv.prime.pizza.api.dao.DAOEmployee;

public class Employee {

	private int id;
	private String name;
	private String identifierNumber;
	private String password;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdentifierNumber() {
		return this.identifierNumber;
	}
	
	public void setIdentifierNumber(String identifierNumber) {
		this.identifierNumber = identifierNumber;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String generateIdentifierNumber() {
		
		final String IDENTIFIER_NUMBER = "EPP";
		
		DAOEmployee employeeDAO = new DAOEmployee();
		
		int lastId = employeeDAO.selectLastId();
		int nextId = lastId + 1;
		
		String identifierNumber = IDENTIFIER_NUMBER + nextId;
		
		return identifierNumber;
		
	}
	
}
