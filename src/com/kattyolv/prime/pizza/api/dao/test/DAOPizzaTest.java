package com.kattyolv.prime.pizza.api.dao.test;

import java.util.ArrayList;

import com.kattyolv.prime.pizza.api.dao.DAOPizza;
import com.kattyolv.prime.pizza.api.model.Pizza;

public class DAOPizzaTest {

	public static void main(String[] args) {
		
		DAOPizzaTest.select();
		DAOPizzaTest.selectPriceById();
		
	}
	
	public static void select() {
		
		System.out.println("DAO PIZZA - LISTING PIZZAS");
		
		DAOPizza pizzaDAO = new DAOPizza();
		ArrayList<Pizza> pizzaList = pizzaDAO.selectData();
		
		for (Pizza pizza : pizzaList) {
			System.out.println(pizza.getName());
		}
	}
	
	public static void selectPriceById() {
		
		System.out.println("DAO PIZZA - SELECT PIZZA BY ID");
		
		DAOPizza pizzaDAO = new DAOPizza();
		Double price = pizzaDAO.selectPriceById(5);
		
		System.out.println(price);
	}
}
