package com.kattyolv.prime.pizza.api.dao.test;

import com.kattyolv.prime.pizza.api.dao.DAOClient;
import com.kattyolv.prime.pizza.api.model.Client;

public class DAOClientTest {

	public static void main(String[] args) {
		
		DAOClientTest.insertTest();
		DAOClientTest.selectTest();
		DAOClientTest.updateTest();
		DAOClientTest.selectClientByEmailAndPassword();
		
	}
	
	public static void insertTest() {
		
		System.out.println("INSERT TEST");
		
		DAOClient clientDAO = new DAOClient();
		Client client = new Client();
		
		// NOTE: if you want to execute this method again, it's necessary to change the info below
		
		client.setName("John");
		client.setAddress("Porto");
		client.setEmail("john@gmail.com");
		client.setPassword("54321");
		
		boolean wasInserted = clientDAO.insertData(client);
		
		if(wasInserted == true) {
			System.out.println("Data inserted successfully.");
		}
		else {
			System.out.println("Fail to insert data.");
		}
	}
	
	public static void selectTest() {
		
		System.out.println("SELECT TEST");
		
		DAOClient clientDAO = new DAOClient();
		
		Client client = clientDAO.selectClientByEmail("john@gmail.com");
		
		if(client != null && client.getEmail().equalsIgnoreCase("john@gmail.com")) {
			System.out.println("Client was found.");
		}
		else {
			System.out.println("Ops! Client does not exist.");
		}
	}
	
	public static void selectClientByEmailAndPassword() {
		
		System.out.println("SELECT BY EMAIL AND PASSWORD TEST");
		
		DAOClient clientDAO = new DAOClient();
		
		Client client = clientDAO.selectClientByEmailAndPassword("john@gmail.com", "54321");
		
		if(client != null) {
			System.out.println("Client existent.");
		}
		else {
			System.out.println("Ops! Client inexistent.");
		}
	}
	
	public static void updateTest() {
		
		System.out.println("UPDATE TEST");
		
		DAOClient clientDAO = new DAOClient();
		Client client = new Client();
		
		client.setName("John");
		client.setAddress("Rua Flores, 33 - Porto");
		client.setEmail("john@gmail.com");
		client.setPassword("54321");
		client.setId(1);
		
		boolean wasUpdated = clientDAO.updateData(client);
		
		if(wasUpdated == true) {
			System.out.println("Update performed successfully.");
		}
		else {
			System.out.println("Failed to update data.");
		}
	}

}
