package com.kattyolv.prime.pizza.api.model;

public class Order {

	private int id;
	private int quantity;
	private String status;
	private double totalPrice;
	private Pizza pizza;
	private Client client;
	private Employee employee;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setTotalPrice(double amount) {
		this.totalPrice = amount;
	}
	
	public Pizza getPizza() {
		return this.pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
