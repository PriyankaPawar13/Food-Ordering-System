package Utility;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DataBaseUtility {

	private static final String URL = "jdbc:mysql://localhost:3306/FoodOrderingSystem";
	private static final String Username = "root";
	private static final String Password = "root";
	
	public static Connection getconnection()throws SQLException {
	//	System.out.print("Connection created....");
	return DriverManager.getConnection(URL,Username,Password);
	}

	
}
