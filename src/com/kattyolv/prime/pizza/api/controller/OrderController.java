package com.kattyolv.prime.pizza.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kattyolv.prime.pizza.api.dao.DAOOrder;
import com.kattyolv.prime.pizza.api.model.Client;
import com.kattyolv.prime.pizza.api.model.Order;
import com.kattyolv.prime.pizza.api.model.Pizza;


@WebServlet("/order")
public class OrderController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			DAOOrder orderDAO = new DAOOrder();
			ArrayList<Order> orders = orderDAO.selectDetailsOrder();
			
			response.setContentType("application/json");
			response.setStatus(200);
			
			PrintWriter out = response.getWriter();
			
			Gson gson = new Gson();
			String ordersJson = gson.toJson(orders);
			
			out.println(ordersJson);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			DAOOrder orderDAO = new DAOOrder();
			Order order = new Order();
			Pizza pizza = new Pizza();
			Client client = new Client();
			
			String idPizza = request.getParameter("idPizza");
			String idClient = request.getParameter("idClient");
			String quantity = request.getParameter("quantity");
			String status = request.getParameter("status");
			String amount = request.getParameter("amount");
			
			if(idPizza == "" || idClient == "" || quantity == "" || status == "" || amount == "" ||
					idPizza == null || idClient == null || quantity == null || status == null || amount == null) {
				
				response.setStatus(400);
				return;
				
			}
			
			int convertedIdPizza = Integer.parseInt(idPizza);
			int convertedIdClient = Integer.parseInt(idClient);
			int convertedQuantity = Integer.parseInt(quantity);
			double convertedAmount = Double.parseDouble(amount);
			
			pizza.setId(convertedIdPizza);
			client.setId(convertedIdClient);
			order.setQuantity(convertedQuantity);
			order.setStatus(status);
			order.setAmount(convertedAmount);
			order.setPizza(pizza);
			order.setClient(client);
			
			boolean wasInserted = orderDAO.insertData(order);
			
			if(wasInserted == true) {
				response.setStatus(200);
			}
			else {
				response.setStatus(400);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DAOOrder orderDAO = new DAOOrder();
			Order order = new Order();
			
			InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream());
			
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			String bodyRequest = bufferedReader.readLine();
			
			String[] bodyRequestSplitted = bodyRequest.split("&");
			
			String idValue = null;
			String statusValue = null;
			
			for(String bodyItem : bodyRequestSplitted) {
				
				if(bodyItem.contains("id")) {
					idValue = bodyItem.replace("id=", "");
				}
				else if(bodyItem.contains("status")) {
					statusValue = bodyItem.replace("status=", "");
				}
			}
			
			if(idValue == "" || idValue == null) {
				response.setStatus(400);
				response.getWriter().println("Id is required.");
				return;
			}
			
			if(statusValue == "" || statusValue == null) {
				response.setStatus(400);
				response.getWriter().println("Status is required.");
				return;
			}
			
			int convertedId = Integer.parseInt(idValue);
			
			order.setId(convertedId);
			order.setStatus(statusValue);
			
			boolean wasUpdated = orderDAO.updateStatus(order);
			
			if(wasUpdated == true) {
				response.setStatus(200);
			}
			else {
				response.setStatus(400);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
		
	}
}
