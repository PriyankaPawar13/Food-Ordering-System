package Services;

import java.sql.SQLException;
import java.util.List;
import DAO.FoodItemDAO;
import Models.FoodItem;

public class FoodItemService {
    private FoodItemDAO foodItemDAO = new FoodItemDAO();

    public void addFoodItem(FoodItem foodItem) throws SQLException {
        foodItemDAO.addFoodItem(foodItem);
    }

    public List<FoodItem> getAllFoodItems() throws SQLException {
        return foodItemDAO.getAllFoodItems();
    }

    public FoodItem getFoodItemById(int id) throws SQLException {
        return foodItemDAO.getFoodItemById(id);
    }

    public void updateFoodItem(FoodItem foodItem) throws SQLException {
        foodItemDAO.updateFoodItem(foodItem);
    }

    public void deleteFoodItem(int id) throws SQLException {
        foodItemDAO.deleteFoodItem(id);
    }
    
    public double getPriceBYId(int id) throws SQLException
    {
    	return  foodItemDAO.getPriceBYId(id);
		
    }
}

