package com.kattyolv.prime.pizza.api.dao.test;

import java.util.ArrayList;

import com.kattyolv.prime.pizza.api.dao.DAOPizza;
import com.kattyolv.prime.pizza.api.model.Pizza;

public class DAOPizzaTest {

	public static void main(String[] args) {
		
		System.out.println("DAO PIZZA - LISTING PIZZAS");
		
		DAOPizza dao = new DAOPizza();
		ArrayList<Pizza> pizzaList = dao.selectData();
		
		for (Pizza pizza : pizzaList) {
			System.out.println(pizza.getName());
		}
		
	}
}
