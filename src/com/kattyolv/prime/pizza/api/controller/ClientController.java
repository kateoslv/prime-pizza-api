package com.kattyolv.prime.pizza.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kattyolv.prime.pizza.api.dao.DAOClient;
import com.kattyolv.prime.pizza.api.model.Client;

@WebServlet("/client")
public class ClientController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		if (email == null) {
			response.setStatus(400);
		} 
		else {
			DAOClient clientDAO = new DAOClient();

			Client client = clientDAO.selectClientByEmail(email);

			if (client != null) {

				Gson gson = new Gson();
				String clientJson = gson.toJson(client);

				response.setContentType("application/json");

				PrintWriter out = response.getWriter();
				out.print(clientJson);

				response.setStatus(200);
			} 
			else {
				response.setStatus(204);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DAOClient clientDAO = new DAOClient();
			Client client = new Client();

			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			client.setName(name);
			client.setAddress(address);
			client.setEmail(email);
			client.setPassword(password);

			boolean wasInserted = clientDAO.insertData(client);

			if (wasInserted == true) {
				response.setStatus(200);
			} 
			else {
				response.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DAOClient clientDAO = new DAOClient();
			Client client = new Client();

			InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String data = bufferedReader.readLine();

			String[] splittedData = data.split("&");

			for (int i = 0; i < splittedData.length; i++) {
				
				String[] splittedParameter = splittedData[i].split("=");

				String key = splittedParameter[0];
				
				if(splittedParameter.length > 1) {
					
					String value = splittedParameter[1];
					
					switch (key) {
						case "id":
							int id = Integer.parseInt(value);
							client.setId(id);
							break;
						case "name":
							client.setName(value);
							break;
						case "address":
							client.setAddress(value);
							break;
						case "email":
							client.setEmail(URLDecoder.decode(value, "UTF-8"));
							break;
						case "password":
							client.setPassword(value);
							break;
					}
				}
				else {
					response.getWriter().println(key + " is required!");
					response.setStatus(400);
					return;
				}
			}
			
			if(client.getId() == 0) {
				response.getWriter().println("id is required!");
				response.setStatus(400);
				return;
			}
			
			if(client.getName() == null) {
				response.getWriter().println("name is required!");
				response.setStatus(400);
				return;
			}
			
			if(client.getAddress() == null) {
				response.getWriter().println("address is required!");
				response.setStatus(400);
				return;
			}
			
			if(client.getEmail() == null) {
				response.getWriter().println("email is required!");
				response.setStatus(400);
				return;
			}
			
			if(client.getPassword() == null) {
				response.getWriter().println("password is required!");
				response.setStatus(400);
				return;
			}
			
			boolean hasUpdated = clientDAO.updateData(client);
			
			if(hasUpdated == true) {
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
