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
import Utility.DataBaseUtility;

public class FoodItemDAO {

 public FoodItem  getFoodItemById(int id) throws SQLException {
	  	FoodItem foodItem = null;
    	 String SELECT_BYID = "SELECT * FROM FoodItem WHERE itemId = ?";
    	 Connection connection = DataBaseUtility.getconnection();
    	 PreparedStatement stmt = connection.prepareStatement(SELECT_BYID);
    	 stmt.setInt(1, id);
    	 try (ResultSet rs = stmt.executeQuery()) {
             if (rs.next()) {
                 foodItem = new FoodItem();
                 foodItem.setItemID(rs.getInt(1));
                 foodItem.setItemName(rs.getString(2));
                 foodItem.setItemPrice(rs.getDouble(3));     
             }
         }
         return foodItem;
 }
 
 public double getPriceBYId(int id) throws SQLException
 {
	 String SELECT_BYID = "SELECT PRICE FROM FOODITEM WHERE ITEMID = ?";
	 Connection connection = DataBaseUtility.getconnection();
	 PreparedStatement stmt = connection.prepareStatement(SELECT_BYID);
	 stmt.setInt(1,id);
	 ResultSet result = stmt.executeQuery();
	 if(result.next())
	 {
		 return result.getDouble("Price");
	 }
	 return 0.0;
 }
 
 

 public List<FoodItem> getAllFoodItems() throws SQLException {
     List<FoodItem> foodItems = new ArrayList<>();

    	 String SELECT_Query = "SELECT * FROM FoodItem" ;
    	 Connection connection = DataBaseUtility.getconnection();
    	 Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(SELECT_Query);
      
         while (resultSet.next()) {
             FoodItem foodItem = new FoodItem();
             foodItem.setItemID(resultSet.getInt("itemId"));
             foodItem.setItemName(resultSet.getString("itemName"));
             foodItem.setItemPrice(resultSet.getDouble("price"));
             foodItems.add(foodItem);
         }
     return foodItems;
 }

     
 public void addFoodItem(FoodItem foodItem) throws SQLException {
    	 Connection connection = DataBaseUtility.getconnection();
         PreparedStatement statement = connection.prepareStatement("INSERT INTO FoodItem (itemName, price) VALUES (?, ?)");
         statement.setString(1, foodItem.getItemName());
         statement.setDouble(2, foodItem.getItemPrice());
         statement.executeUpdate();
 }

 public void updateFoodItem(FoodItem foodItem) throws SQLException {

    	 Connection connection = DataBaseUtility.getconnection();
         PreparedStatement statement = connection.prepareStatement("UPDATE FoodItem SET itemName = ?, price = ? WHERE itemId = ?");
         statement.setString(1, foodItem.getItemName());
         statement.setDouble(2, foodItem.getItemPrice());
         statement.setInt(3, foodItem.getItemID());
         statement.executeUpdate();
         statement.close();
     
 }

 public void deleteFoodItem(int id) throws SQLException {
    	 Connection connection = DataBaseUtility.getconnection();
         PreparedStatement statement = connection.prepareStatement("DELETE FROM FoodItem WHERE itemId = ?");
         statement.setInt(1, id);
         statement.executeUpdate();
 		}
}
