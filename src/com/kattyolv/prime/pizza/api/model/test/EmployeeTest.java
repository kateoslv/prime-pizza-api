package com.kattyolv.prime.pizza.api.model.test;

import com.kattyolv.prime.pizza.api.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		System.out.println("EMPLOYEE");

		Employee employee = new Employee();
		employee.setId(4);
		employee.setName("ana");
		employee.setIdentifierNumber(5);
		employee.setPassword("221");
		
		if(employee.getId() == 4 &&
				employee.getName() == "ana" &&
				employee.getIdentifierNumber() == 5 &&
				employee.getPassword() == "221") {
			
			System.out.println("Everything here looks GRRREAT.");
		}
		
	}

}
