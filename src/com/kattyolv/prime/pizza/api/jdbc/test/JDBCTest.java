package com.kattyolv.prime.pizza.api.jdbc.test;

import com.kattyolv.prime.pizza.api.jdbc.ConnectionJDBC;

public class JDBCTest {

	public static void main(String[] args) {
		
		ConnectionJDBC connection = new ConnectionJDBC();
		connection.getConnection();
		
	}

}
