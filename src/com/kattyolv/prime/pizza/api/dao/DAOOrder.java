package com.kattyolv.prime.pizza.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kattyolv.prime.pizza.api.jdbc.ConnectionJDBC;
import com.kattyolv.prime.pizza.api.model.Employee;
import com.kattyolv.prime.pizza.api.model.Order;
import com.kattyolv.prime.pizza.api.model.Pizza;

public class DAOOrder {

	private static final String INSERT = "INSERT INTO `order` (id_pizza, id_client, quantity, status, "
			+ "amount) VALUES (?,?,?,?,?)";
	private static final String SELECT_DETAILS_ORDER = "SELECT o.id, o.quantity, p.name AS pizza, "
			+ "e.name AS employee, o.`status` FROM `order` o "
			+ "INNER JOIN pizza p ON p.id = o.id_pizza "
			+ "LEFT JOIN employee e ON e.id = o.id_employee";
	private static final String UPDATE_STATUS = "UPDATE `order` SET `status` = ? WHERE id = ?";
	
	
	private static Connection connection;
	
	public DAOOrder() {
		ConnectionJDBC connectionJDBC = new ConnectionJDBC();
		connection = connectionJDBC.getConnection();
	}
	
	public boolean insertData(Order order) {
		
		boolean wasInserted = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement(INSERT);
		
			statement.setInt(1, order.getPizza().getId());
			statement.setInt(2, order.getClient().getId());
			statement.setInt(3, order.getQuantity());
			statement.setString(4, order.getStatus());
			statement.setDouble(5, order.getAmount());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				wasInserted = true;
			}		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return wasInserted;
	}
	
	public ArrayList<Order> selectDetailsOrder() {
		
		ArrayList<Order> orders = new ArrayList<Order>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_DETAILS_ORDER);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Order order = new Order();
				Employee employee = new Employee();
				Pizza pizza = new Pizza();
				
				order.setId(resultSet.getInt("id"));
				order.setQuantity(resultSet.getInt("quantity"));
				order.setStatus(resultSet.getString("status"));
				
				String employeeName = resultSet.getString("employee");
				employee.setName(employeeName);
				
				order.setEmployee(employee);
				
				String pizzaName = resultSet.getString("pizza");
				pizza.setName(pizzaName);
				
				order.setPizza(pizza);
				
				orders.add(order);
			}
			
			return orders;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
