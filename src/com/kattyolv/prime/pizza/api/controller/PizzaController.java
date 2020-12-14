package com.kattyolv.prime.pizza.api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kattyolv.prime.pizza.api.dao.DAOPizza;
import com.kattyolv.prime.pizza.api.model.Pizza;


@WebServlet("/pizzas")
public class PizzaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		DAOPizza pizzaDAO = new DAOPizza();
		
		ArrayList<Pizza> pizzas = pizzaDAO.selectData();
		
		String pizzasJson = gson.toJson(pizzas);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		
		out.print(pizzasJson);
		
	}
	
}
