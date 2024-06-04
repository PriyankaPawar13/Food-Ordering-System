package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Models.Customer;

import Utility.DataBaseUtility;

public class CustomerDAO {

	
	public void addCustomer(Customer customer) throws SQLException
	{
		String Insert_Query = "INSERT INTO CUSTOMER(NAME,LOCATION,PHONE_NUM) VALUES(?,?,?)";
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(Insert_Query);
		stmt.setString(1, customer.getName());
		stmt.setString(2, customer.getLocation());
		stmt.setString(3, customer.getPhone_Number());
		stmt.executeUpdate();
	
	}

	public List<Customer> getAllCustomer() throws SQLException
	{
		List<Customer> customer = new ArrayList<>();
		String SELECT_QUERY = "Select * from Customer";
		Connection connection = DataBaseUtility.getconnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_QUERY);
		
		while(rs.next())
		{
			Customer customer1 = new Customer();
			customer1.setId(rs.getInt(1));
			customer1.setName(rs.getString(2));
			customer1.setLocation(rs.getString(3));
			customer1.setPhone_Number(rs.getString(4));
			customer.add(customer1);
	
		}
		return customer;
		
	}
	
	public void updateCustomer(Customer customer) throws SQLException
	{
		String Update_Query = "Update Customer SET name = ?, Location =? ,PHONE_NUM = ? WHERE ID = ?";
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(Update_Query);
		stmt.setString(1, customer.getName());
		stmt.setString(2, customer.getLocation());
		stmt.setString(3, customer.getPhone_Number());
		stmt.setInt(4, customer.getId());
		stmt.executeUpdate();
		
	}
	
	public void deleteCustomer(int id) throws SQLException
	{	
		String Delete_Query = "DELETE FROM CUSTOMER WHERE ID = ?";
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement(Delete_Query);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
	}

	public Customer getCustomerById(int id) throws SQLException
	{
		Customer customer = null;
		Connection connection = DataBaseUtility.getconnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE ID = ?");
		stmt.setInt(1, id);
		try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setLocation("Location");
                customer.setPhone_Number("Phone_Num");
            }
        }
        return customer;
	}

}
