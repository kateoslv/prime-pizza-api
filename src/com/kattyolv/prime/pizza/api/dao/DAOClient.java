package com.kattyolv.prime.pizza.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kattyolv.prime.pizza.api.jdbc.ConnectionJDBC;
import com.kattyolv.prime.pizza.api.model.Client;

public class DAOClient {

	private static final String INSERT = "INSERT INTO client (name, address, email, password) "
			+ "VALUES (?,?,?,?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM client WHERE email=?";
	private static final String UPDATE = "UPDATE client SET name=?, address=?, email=?, password=? WHERE id=?";
	
	private static Connection connection; 
	
	public DAOClient() {
		ConnectionJDBC connectionJDBC = new ConnectionJDBC();
		connection = connectionJDBC.getConnection();
	}
	
	public boolean insertData(Client client) {
		
		try {
			PreparedStatement statement = connection.prepareStatement(INSERT);
			
			statement.setString(1, client.getName());
			statement.setString(2, client.getAddress());
			statement.setString(3, client.getEmail());
			statement.setString(4, client.getPassword());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				return true;
			}			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
