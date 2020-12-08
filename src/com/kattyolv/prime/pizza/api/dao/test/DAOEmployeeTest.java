package com.kattyolv.prime.pizza.api.dao.test;

import com.kattyolv.prime.pizza.api.dao.DAOEmployee;

public class DAOEmployeeTest {

	public static void main(String[] args) {
		
		DAOEmployeeTest.selectLastIdTest();

	}
	
	public static void selectLastIdTest() {
		
		System.out.println("SELECT LAST ID EMPLOYEE");
		
		DAOEmployee employee = new DAOEmployee();
		int resultExpected = employee.selectLastId();
		
		if(resultExpected == 0) {
			System.out.println("Result expected.");
		}
		else {
			System.out.println("This was not the expected result.");
		}
	}

}
