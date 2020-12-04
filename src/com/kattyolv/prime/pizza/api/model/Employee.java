package com.kattyolv.prime.pizza.api.model;

public class Employee {

	private int id;
	private String name;
	private int identifierNumber;
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
	
	public int getIdentifierNumber() {
		return this.identifierNumber;
	}
	
	public void setIdentifierNumber(int identifierNumber) {
		this.identifierNumber = identifierNumber;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
