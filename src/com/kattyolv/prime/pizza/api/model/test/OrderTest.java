package com.kattyolv.prime.pizza.api.model.test;

import com.kattyolv.prime.pizza.api.model.Client;
import com.kattyolv.prime.pizza.api.model.Employee;
import com.kattyolv.prime.pizza.api.model.Order;
import com.kattyolv.prime.pizza.api.model.Pizza;

public class OrderTest {

	public static void main(String[] args) {
		
		System.out.println("ORDER");
		
		Order order = new Order();
		order.setId(2);
		order.setQuantity(3);
		order.setStatus("approved");
		order.setTotalPrice(25);
		
		Pizza pizza = new Pizza();
		pizza.setName("peperoni");
		
		order.setPizza(pizza);
		
		Client client = new Client();
		client.setName("samuel");
		
		order.setClient(client);
		
		Employee employee = new Employee();
		employee.setName("ana");
		
		order.setEmployee(employee);
		
		if(order.getId() == 2 &&
				order.getQuantity() == 3 &&
				order.getStatus() == "approved" &&
				order.getTotalPrice() == 25 &&
				order.getPizza().getName() == "peperoni" &&
				order.getClient().getName() == "samuel" &&
				order.getEmployee().getName() == "ana") {
			
			System.out.println("Everything here looks GRRREAT..");
			
		}

	}

}
