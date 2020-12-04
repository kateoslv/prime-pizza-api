package com.kattyolv.prime.pizza.api.model.test;

import com.kattyolv.prime.pizza.api.model.Client;

public class ClientTest {

	public static void main(String[] args) {
		
		System.out.println("CLIENT");
		
		Client client = new Client();
		client.setId(3);
		client.setName("samuel");
		client.setAddress("porto");
		client.setEmail("sam@gmail.com");
		client.setPassword("4321");
		
		if(client.getId() == 3 &&
				client.getName() == "samuel" &&
				client.getAddress() == "porto" &&
				client.getEmail() == "sam@gmail.com" &&
				client.getPassword() == "4321") {
			
			System.out.println("Everything here looks GRRREAT.");
		}

	}

}
