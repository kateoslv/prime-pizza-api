package com.kattyolv.prime.pizza.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kattyolv.prime.pizza.api.jdbc.ConnectionJDBC;
import com.kattyolv.prime.pizza.api.model.Pizza;


public class DAOPizza {

	private static final String SELECT = "SELECT * FROM pizza";
	
	static Connection connection;
	
	public DAOPizza() {
		ConnectionJDBC connectionJDBC = new ConnectionJDBC();
		connection = connectionJDBC.getConnection();
	}
	
	public ArrayList<Pizza> selectData() {
		
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT);
			
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
			
			while(resultSet.next()) {
				
				Pizza pizza = new Pizza();
				
				pizza.setId(resultSet.getInt("id"));
				pizza.setName(resultSet.getString("name"));
				pizza.setDescription(resultSet.getString("description"));
				pizza.setPrice(resultSet.getDouble("price"));
				pizza.setImageUrl(resultSet.getString("image_url"));
				
				pizzaList.add(pizza);
			}
			
			return pizzaList;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
