package com.kattyolv.prime.pizza.api.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	
	private Connection connection = null;
	private static final String USER = "root";
	private static final String PASSWORD = "123456*";
	private static final String URL = "jdbc:mysql://localhost:3306/prime_pizza_api";
	
	public Connection getConnection() {
		
		if (connection == null) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	public void closeConnection() {
		
		if (connection != null) {
			try {
				connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
