package com.kattyolv.prime.pizza.api.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kattyolv.prime.pizza.api.cors.Cors;
import com.kattyolv.prime.pizza.api.dao.DAOClient;
import com.kattyolv.prime.pizza.api.model.Client;


@WebServlet("/client/sign-in")
public class ClientSignInController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cors.applyPermissionsHeaders(response);
		
		try {
			DAOClient clientDAO = new DAOClient();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			Client client = clientDAO.selectClientByEmailAndPassword(email, password);
			
			if(client != null) {
				
				Gson gson = new Gson();
				String clientJson = gson.toJson(client);
				
				response.setContentType("application/json");
				
				PrintWriter out = response.getWriter();
				out.println(clientJson);
				
				response.setStatus(200);
			}
			else {
				response.setStatus(401);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
		
	}

}
