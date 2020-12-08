package com.kattyolv.prime.pizza.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.kattyolv.prime.pizza.api.jdbc.ConnectionJDBC;
import com.kattyolv.prime.pizza.api.model.Employee;

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
	
	private boolean executeInsertQuery(Employee employee) throws SQLIntegrityConstraintViolationException,
		SQLException {
		
		PreparedStatement statement = connection.prepareStatement(INSERT);
		
		statement.setString(1, employee.getName());
		statement.setString(2, employee.generateIdentifierNumber());
		statement.setString(3, employee.getPassword());
		
		int rowsAffected = statement.executeUpdate();
		
		if(rowsAffected > 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean insertData(Employee employee) {
		
		boolean wasInserted = false;
		
		try {			
			wasInserted = this.executeInsertQuery(employee);	
		}
		catch (SQLIntegrityConstraintViolationException e) {	
			
			try {				
				wasInserted = this.executeInsertQuery(employee);		
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wasInserted;
	}
	
}
