package com.kattyolv.prime.pizza.api.dao.test;

import com.kattyolv.prime.pizza.api.dao.DAOOrder;
import com.kattyolv.prime.pizza.api.model.Client;
import com.kattyolv.prime.pizza.api.model.Employee;
import com.kattyolv.prime.pizza.api.model.Order;
import com.kattyolv.prime.pizza.api.model.Pizza;

public class DAOOrderTest {

	public static void main(String[] args) {
		
		DAOOrderTest.insertData();

	}
	
	public static void insertData() {
		
		System.out.println("INSERT TEST");
		
		DAOOrder orderDAO = new DAOOrder();
		
		Pizza pizza = new Pizza();
		pizza.setId(3);
		
		Client client = new Client();
		client.setId(1);
		
		Order order = new Order();
		order.setQuantity(1);
		order.setStatus("Processing");
		order.setAmount(9.90);
		order.setPizza(pizza);
		order.setClient(client);
		
		boolean wasInserted = orderDAO.insertData(order);
		
		if(wasInserted == true) {
			System.out.println("Data was inserted successfully.");
		}
		else {
			System.out.println("Failed to insert data.");
		}
	}

}
