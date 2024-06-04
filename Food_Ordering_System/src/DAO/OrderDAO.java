package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.Customer;
import Models.FoodItem;
import Models.Order;
import Utility.DataBaseUtility;

public class OrderDAO {

	public void addOrder(Order order) throws SQLException {
	
		 Connection connection = DataBaseUtility.getconnection();
		 PreparedStatement stmt = connection.prepareStatement( "insert into `order`(customerid,foodItemId,quantity) values (?,?,?)");
		 stmt.setInt(1, order.getCustomer().getId());
		 stmt.setInt(2, order.getFoodItem().getItemID());		 
		 stmt.setInt(3, order.getQuantity());
		 stmt.executeUpdate();
	}

	public List<Order> getAllOrders() throws SQLException {
		List<Order> orders = new ArrayList<>();
		String SELECT_QUERY = "SELECT * from `order`";
		Connection connection = DataBaseUtility.getconnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_QUERY);
		while(rs.next())
		{
			int orderid = rs.getInt("orderId");
			int customerId = rs.getInt("customerid");
			int foodItemId = rs.getInt("foodItemid");
			int quantity = rs.getInt("quantity");
			
			Customer customer = getCustomerById(customerId);
			FoodItem foodItem = getFoodItembyId(foodItemId);
			orders.add(new Order(orderid,customer,foodItem,quantity));
			
		}
		
		return orders;
	}

	private FoodItem getFoodItembyId(int foodItemId) throws SQLException {
		// TODO Auto-generated method stub
		String QUERY = "SELECT * FROM FOODITEM WHERE ITEMID = ?";
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(QUERY);
		stmt.setInt(1, foodItemId);
		ResultSet result = stmt.executeQuery();
		if(result.next())
		{
			return new FoodItem(result.getInt("ITEMID"),result.getString("ITEMNAME"),result.getDouble("PRICE"));
		}
		
		return null;
	}

	private Customer getCustomerById(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		String QUERY = "SELECT * FROM CUSTOMER WHERE ID = ?";
		Connection connection= DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(QUERY);
		stmt.setInt(1, customerId);
		ResultSet result = stmt.executeQuery();
		if(result.next())
		{
			return new Customer(result.getInt("ID"),result.getString("NAME"),result.getString("Location"),result.getString("Phone_Num"));
		}
		return null;
	}

	public void updateOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		String UPDATE_QUERY = "UPDATE `ORDER` SET CUSTOMERID = ? , foodItemId = ?,quantity = ? WHERE ORDERID = ?";
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
		stmt.setInt(1, order.getCustomer().getId());
		stmt.setInt(2, order.getFoodItem().getItemID());
		stmt.setInt(3, order.getQuantity());
		stmt.setInt(4, order.getOrderID());
		stmt.executeUpdate(UPDATE_QUERY);
	}

	public void deleteOrder(int id) throws SQLException {
		// TODO Auto-generated method stub
		String DELETE_QUERY = "DELETE from `order` where orderId = ?";
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
	}

	public Order getOrderById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String SELECT = "SELECT * FROM `ORDER` WHERE ORDERID = ?";
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(SELECT);
		stmt.setInt(1, id);
		ResultSet result = stmt.executeQuery();
		while(result.next())
		{
			int orderid = result.getInt("orderid");
			int customerid = result.getInt("customerid");
			int foodItemid = result.getInt("Fooditemid");
			int quantity = result.getInt("quantity");
			
			Customer customer = getCustomerById(customerid);
			FoodItem fooditem = getFoodItembyId(foodItemid);
			return new Order(orderid,customer,fooditem,quantity);
		}		
		
		return null;
	}
	
	public int getQuantityBYId(int id) throws SQLException
	 {
		 String SELECT_BYID = "SELECT Quantity FROM `order` WHERE orderid = ?";
		 Connection connection = DataBaseUtility.getconnection();
		 PreparedStatement stmt = connection.prepareStatement(SELECT_BYID);
		 stmt.setInt(1,id);
		 ResultSet result = stmt.executeQuery();
		 if(result.next())
		 {
			 return result.getInt("Quantity");
		 }
		 return 0;
	 }

	public int getOrderId() throws SQLException
	{
		String SELECT_BYID = "SELECT max(orderid) as orderid FROM `order`";
		 Connection connection = DataBaseUtility.getconnection();
		 Statement stmt = connection.createStatement();
		 ResultSet result = stmt.executeQuery(SELECT_BYID);
		 if(result.next())
		 {
			 return result.getInt("orderid");
		 }
		 return 0;
		
	}
	
	public List<Order> getOrderDetailsByCustomerID(int customerid) throws SQLException
	{
		List<Order> orders = new ArrayList<>();
		String SELECT = "select * from `order` where customerid = ?";
	    Connection connection = DataBaseUtility.getconnection();
	    Statement stmt = connection.createStatement();
	    ResultSet result = stmt.executeQuery(SELECT);
	    while(result.next())
	    {
	    	int orderid = result.getInt("orderId");
	    	int customerid1 = result.getInt("customerid");
	    	int foodItemId = result.getInt("fooItemId");
	    	int quantity = result.getInt("qunatity");
	    	
	    	Customer customer = getCustomerById(customerid1);
	    	FoodItem foodItem = getFoodItembyId(foodItemId);
	    	orders.add(new Order(orderid,customer,foodItem,quantity));
	    }
	    return orders;			
				
		}

	

}
