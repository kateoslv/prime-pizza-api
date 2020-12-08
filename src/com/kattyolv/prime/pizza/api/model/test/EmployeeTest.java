package com.kattyolv.prime.pizza.api.model.test;

import com.kattyolv.prime.pizza.api.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		EmployeeTest.employeeTest();
		EmployeeTest.generateIdentifierNumberEmployee();
		
	}

	public static void employeeTest() {
		
		System.out.println("EMPLOYEE");

		Employee employee = new Employee();
		employee.setId(4);
		employee.setName("anne");
		employee.setIdentifierNumber("534");
		employee.setPassword("221");
		
		if(employee.getId() == 4 &&
				employee.getName() == "anne" &&
				employee.getIdentifierNumber() == "534" &&
				employee.getPassword() == "221") {
			
			System.out.println("Everything looks GRRREAT here.");
		}
	}
	
	public static void generateIdentifierNumberEmployee() {
		
		Employee employee = new Employee();
		
		String generatedIdentifierNumber = employee.generateIdentifierNumber();
		
		System.out.println("Identifier number: " + generatedIdentifierNumber);
		
	}
	
}
