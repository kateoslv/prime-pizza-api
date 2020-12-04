package com.kattyolv.prime.pizza.api.model.test;

import com.kattyolv.prime.pizza.api.model.Pizza;

public class PizzaTest {

	public static void main(String[] args) {
		
		System.out.println("PIZZA");
		Pizza pizza = new Pizza();
		pizza.setId(1);
		pizza.setName("carbonara");
		pizza.setDescription("a lot of cheese");
		pizza.setPrice(10);
		
		if(pizza.getId() == 1 &&
				pizza.getName() == "carbonara" && 
				pizza.getDescription() == "a lot of cheese" &&
				pizza.getPrice() == 10) {
			
			System.out.println("Everything here looks GRRREAT.");
		}

	}

}
