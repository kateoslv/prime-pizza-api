package com.kattyolv.prime.pizza.api.dao.test;

import com.kattyolv.prime.pizza.api.dao.DAOEmployee;
import com.kattyolv.prime.pizza.api.model.Employee;

public class DAOEmployeeTest {

	public static void main(String[] args) {
		
		DAOEmployeeTest.selectLastIdTest();
		DAOEmployeeTest.insertData();
		DAOEmployeeTest.selectByIdentifierNumberAndPassword();
		
	}
	
	public static void selectLastIdTest() {
		
		System.out.println("SELECT LAST ID EMPLOYEE");
		
		DAOEmployee employeeDAO = new DAOEmployee();
		int resultExpected = employeeDAO.selectLastId();
		
		if(resultExpected == 0) {
			System.out.println("Result expected.");
		}
		else {
			System.out.println("This was not the expected result.");
		}
	}
	
	public static void selectByIdentifierNumberAndPassword() {
		
		System.out.println("SELECT BY IDENTIFIER NUMBER AND PASSWORD - TEST");
		
		DAOEmployee employeeDAO = new DAOEmployee();
		Employee employee = employeeDAO.selectEmployeeByIdentifierNumberAndPassword("EPP1", "221");
		
		if(employee != null) {
			System.out.println("Employee does exist.");
		}
		else {
			System.out.println("Ops! Employee not found.");
		}
	}
	
	public static void insertData() {
		
		System.out.println("INSERT TEST");
		
		DAOEmployee employeeDAO = new DAOEmployee();
		Employee employee = new Employee();
		
		employee.setName("jane");
		employee.setPassword("665");
		
		boolean wasInserted = employeeDAO.insertData(employee);
		
		if(wasInserted == true) {
			System.out.println("Data was inserted successfully.");
		}
		else {
			System.out.println("Failed to insert data.");
		}
	}
	
}
