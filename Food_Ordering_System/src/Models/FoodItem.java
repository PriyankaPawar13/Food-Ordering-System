package Models;

public class FoodItem {
	
	private int itemID;
	private String itemName;
	private double itemPrice;
	
	public FoodItem() {
		super();
	}

	public FoodItem(int itemID, String itemName, double itemPrice) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	
	public String toString() {
		return "FoodItems [itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	
}
