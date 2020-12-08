package com.kattyolv.prime.pizza.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kattyolv.prime.pizza.api.jdbc.ConnectionJDBC;

public class DAOEmployee {

	private static final String SELECT_LAST_ID = "SELECT MAX(id) AS last_id FROM employee";
	private static final String INSERT = "INSERT INTO employee (name, identifier_number, password) "
			+ "VALUES (?,?,?)";
	
	private static Connection connection;
	
	public DAOEmployee() {
		ConnectionJDBC connectionJDBC = new ConnectionJDBC();
		connection = connectionJDBC.getConnection();
	}
	
	public int selectLastId() {
		
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_LAST_ID);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				
				int lastId = resultSet.getInt("last_id");
				
				return lastId;
			}
 		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
