package com.kattyolv.prime.pizza.api.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kattyolv.prime.pizza.api.dao.DAOOrder;
import com.kattyolv.prime.pizza.api.model.Client;
import com.kattyolv.prime.pizza.api.model.Order;
import com.kattyolv.prime.pizza.api.model.Pizza;


@WebServlet("/order")
public class OrderController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
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

}
