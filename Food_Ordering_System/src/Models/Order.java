package Models;

import java.util.List;

public class Order {
	
	private int orderID;
	private Customer customer;
	private FoodItem foodItem;
	private int quantity;
	
	public Order() {
		super();
	}

	public Order(int orderID, Customer customer, FoodItem foodItem, int quantity) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.foodItem = foodItem;
		this.quantity = quantity;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return "Order [orderID=" + orderID + ", customer=" + customer + ", foodItem=" + foodItem + ", quantity="
				+ quantity + "]";
	}
	
	
}
