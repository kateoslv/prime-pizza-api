package com.kattyolv.prime.pizza.api.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kattyolv.prime.pizza.api.dao.DAOEmployee;
import com.kattyolv.prime.pizza.api.model.Employee;


@WebServlet("/employee/sign-in")
public class EmployeeSignInController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			DAOEmployee employeeDAO = new DAOEmployee();
			
			String identifierNumber = request.getParameter("identifier_number");
			String password = request.getParameter("password");
			
			Employee employee = employeeDAO.selectEmployeeByIdentifierNumberAndPassword(identifierNumber, password);
			
			if(employee != null) {
				
				Gson gson = new Gson();
				
				String employeeJson = gson.toJson(employee);
				
				response.setContentType("application/json");
				
				PrintWriter out = response.getWriter();
				
				out.println(employeeJson);
				
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
