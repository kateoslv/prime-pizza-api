package com.kattyolv.prime.pizza.api.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kattyolv.prime.pizza.api.cors.Cors;
import com.kattyolv.prime.pizza.api.dao.DAOEmployee;
import com.kattyolv.prime.pizza.api.model.Employee;


@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cors.applyPermissionsHeaders(response);
		
		try {
			
			DAOEmployee employeeDAO = new DAOEmployee();
			Employee employee = new Employee();
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			employee.setName(name);
			employee.setPassword(password);
			
			boolean hasInserted = employeeDAO.insertData(employee);
			
			if(hasInserted == true) {
				response.setStatus(200);
			}
			else {
				response.setStatus(400);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		}
		
	}
}
