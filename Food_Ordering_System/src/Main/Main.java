package Main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import Models.Customer;
import Models.FoodItem;
import Models.Order;
import Services.CustomerService;
import Services.FoodItemService;
import Services.OrderService;

public class Main {
	
	private Scanner scan;
	private CustomerService customerService;
	private FoodItemService foodItemService;
	private OrderService orderService;
//	private OrderDAO orderDAO;
	
	public static void main(String args[]) throws SQLException
	{
		Main main = new Main();
		main.run();
	}
	
    public Main() {
        customerService = new CustomerService();
        foodItemService = new FoodItemService();
        orderService = new OrderService();
//        orderDAO = new OrderDAO();
        scan = new Scanner(System.in);
        
    }
    
    public void run() throws SQLException
    {
    	System.out.println("==================================");
        System.out.println("    Food Ordering System");
    	System.out.println("==================================");
    
    	System.out.println("1.Already Registered\n2."
    			+ "Create New Account\n3."
    			+ "Admin Login");   	
//    	int key = Integer.parseInt(scan.nextLine());
    	int key = scan.nextInt();
    	OptionMenu(key);
    }
    
    private void OptionMenu(int key) throws SQLException
    { 	
    	if(key == 1)
    	while (true) {
    		showOrderMenu();
    		int choice = scan.nextInt();
    		switch (choice) {
    			  case 1: 
    				  viewAllFoodItems();
    				  break;
				  case 2:
				       addOrder();
				       break;
				  case 3:
					  deleteOrder();
					  break;
				  case 4:
					  getOrderDetailsByCustomerID();
					  break;  
				  case 5:
					  updateOrderById();
					  break;
				  case 6:
					  System.out.println("Exiting...\nThank You");
					  return;
					  
				  default:
					  System.out.println("Invalid choice. Try again.");
				 }
    			}
    
    	else if(key == 2)
    	{
    		registerCustomer();
    		System.out.println();
    		System.out.println("Wants to an order Something..");
    		System.out.println("If Yes Press 1...if No Press 0");
    		int key1 = scan.nextInt();
    		if(key1 == 1)
    		{    			
    			OptionMenu(key1);
    		}else
    		{
    			System.out.println("Thank You For Registering...");
    		}
    		
    		}
    	else if(key == 3)
    		{
    		while (true) {
    			showAdminMenu();
//    			scan.nextLine();
    			int choice = scan.nextInt();
//        		int choice = Integer.parseInt(scan.nextLine());
        		switch (choice) {
    				  case 1:
    				       AddCustomer();
    				       break;
    				  case 2:
    				       viewAllCustomer();
    				       break;
    				  case 3:
    				       updateCustomer();
    				       break;
    				  case 4:
    					  deleteCustomer();
    					  break;
    				  case 5:
    					  addFooditems();
    					  break;
    				  case 6 :
    					  deleteFooditems();
    					  break;
    				  case 7 :
    					  viewAllFoodItems();
    					  break;
    				  case 8:
    					  viewAllOrders();
    					  break;
    				  case 9:
    					  getOrderDetailsByCustomerID();
    					  break;
    				  case 10 :
    					  getQuantityByOrderId();
    					  break;
    				  case 11:
    					  deleteOrder();
    					  break;
    				  case 12:
    					  updateOrderById();
    					  break;
    				  case 13 :
    					  System.out.println("Exiting...\nThank You !");
    					  return;
    				  default:
    					  System.out.println("Invalid choice. Try again.");
    				 }
    		    }
    		}
    	else 
    		{
    		System.out.println("Invalid Input ....");	
    		}
    }
    
	
	private void updateOrderById() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Order ID :");
		int orderid  = scan.nextInt();
		Order orderUpdate = orderService.getOrderById(orderid);
		if(orderUpdate != null)
		{		
			System.out.println("Enter Customer ID :");
			int customerid = scan.nextInt();
			System.out.println("Enter Food Item By ID : ");
			int fooditemid = scan.nextInt();
			System.out.println("Enter Quantity :");
			int quantity = scan.nextInt();
			Customer customer = customerService.getCustomerById(customerid);
			FoodItem foodItem = foodItemService.getFoodItemById(fooditemid);
	//		System.out.println(orderUpdate);
			orderService.updateOrder(new Order(orderid,customer,foodItem,quantity));	
			System.out.println("Order has been updated...");
		}else
		{
			System.out.println("Oops!!...You Have Entered Wrong Order ID Check it Again");
		}		
		
	}

	private void getQuantityByOrderId() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Order ID :");
		int orderid  = scan.nextInt();
		int quantity = orderService.getQuantityBYId(orderid);
		if(quantity > 1)
		System.out.println("Placed Quantity of "+orderid+" is : "+quantity);
		else
			System.out.println("Orderid not Found...");
		
	}

	private void getOrderDetailsByCustomerID() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Customer ID : ");
		int customerid  =  scan.nextInt();
		System.out.println("Orders for customer ID " + customerid + ":");
//		System.out.println(orderService.getOrderDetailsByCustomerID(customerid));
		Customer customer = customerService.getCustomerById(customerid);
		if(customerService.getCustomerById(customerid)==null)
        {
        	System.out.println("!! Check Customer ID Again !!");
        }
        else 
        {
			if(orderService.getOrderDetailsByCustomerID(customerid).isEmpty())
			{
				System.out.println("Customer has not placed Any Order yet..");
			}
			else
			{
			List<Order> all = orderService.getOrderDetailsByCustomerID(customerid);
			
			System.out.printf("%-10s %-10s %-3s","OrderID ","Item ","Quantity");
			System.out.println();
			
	//		System.out.printf("%-9s %-1s %-80s %-1s %-56s %-1s %-3s\n","Order ID ","|","Customer Details","|","FoodItem Details","|","Placed Quantity");
	    	System.out.println("---------------------------------------------------");
	    	String Name = "";
	    	for(Order order : all)
	    	{
	    		System.out.printf("%-10s %-10s %-3s",order.getOrderID(),order.getFoodItem().getItemName(),order.getQuantity());
	    		System.out.println();
	    		Name  = order.getCustomer().getName();
	    	}	
	    	System.out.println("---------------------------------------------------");
	    	System.out.println("Order Details For "+Name);
	    	System.out.println();
			}
        }
	}

	private void deleteOrder() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter Order Id to cancel Order : ");
		int order1 = scan.nextInt();
		Order order =  orderService.getOrderById(order1);
//		System.out.println(order);
		if(order != null) {
			System.out.println("Are you sure to cancel Order ? YES/NO");
			String choice = scan.next();
			if(choice.equalsIgnoreCase("YES"))
			{
			orderService.deleteOrder(order.getOrderID());
			System.out.println("Order Cancelled...!");
			}
			else {
				System.out.println("OK ,Order is not cancelled");
			}
		}else
		{
			System.out.println("Wrong Order ID :");
			
		}
		
	}

	private void viewAllOrders() throws SQLException {
    
    	List<Order> all = orderService.getAllOrders();
    	System.out.printf("%-9s %-1s %-80s %-1s %-60s %-1s %-3s\n","Order ID ","|","Customer Details","|","FoodItem Details","|","Placed Quantity");
    	System.out.println();
    	for(Order order : all)
    	{
    		System.out.printf("%-9s %-1s %-80s %-1s %-60s %-1s %-3s\n",order.getOrderID(),"|",order.getCustomer(),"|",order.getFoodItem(),"|",order.getQuantity());
    	}
		
	}

	private void viewAllFoodItems() throws SQLException {
    	
    	List<FoodItem> all = foodItemService.getAllFoodItems();
    	
    	System.out.println("Menu Card :");
    	System.out.println("-------------------------");
    	System.out.printf("%-3s %-9s %-5s\n","ID","ItemName","ItemPrice");
    	System.out.println("-------------------------");
    	for(FoodItem food : all)
    	{
//    		System.out.println("Id :"+ food.getItemID()+", Item Name :  "+food.getItemName()+", Price: "+food.getItemPrice());

    		System.out.printf("%-3s %-9s %-5s\n",food.getItemID(),food.getItemName(),food.getItemPrice());
    	}
    	System.out.println("-------------------------");
    	System.out.println();
	
	}

	private void deleteFooditems() throws SQLException {
		// TODO Auto-generated method stub
		scan.nextLine();
    	System.out.println("Enter number of food items to delete:");
        int foodItemCount = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= foodItemCount; i++) {
            System.out.println("Enter food item id:");
//            int id = scan.nextInt();
            foodItemService.deleteFoodItem(scan.nextInt());
            System.out.println("Food Item deleted Succussfully");
        }
		
	}

	private void addFooditems() throws SQLException {
		// 
		scan.nextLine();
    	System.out.println("Enter number of food items to add:");
        int foodItemCount = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= foodItemCount; i++) {
            System.out.println("Enter food item name:");
            String foodItemName = scan.nextLine();
            System.out.println("Enter food item price:");
            double foodItemPrice = Double.parseDouble(scan.nextLine());
            FoodItem foodItem = new FoodItem( 0, foodItemName, foodItemPrice);  // ID will be auto-incremented
            foodItemService.addFoodItem(foodItem);
        }
        System.out.println("Food item Added Succussfully");
		
	}

	private void addOrder() throws SQLException {
        //place order
		double BillSum =0.0;
		viewAllFoodItems();
		System.out.println("Enter numbers of Item to Order:");
        int orderCount = scan.nextInt();
            System.out.println("Select customer by ID:");
            System.out.println("---------------------------------");
            System.out.printf("%-5s %-10s","ID ","Customers Name ");
            System.out.println();
            System.out.println("---------------------------------");

            List<Customer> customers = customerService.getAllCustomer();
            for (Customer customer : customers) {
                System.out.printf("%-5s %-10s",customer.getId(),customer.getName());
                System.out.println();
            }

            System.out.println("---------------------------------");
            int customerId = scan.nextInt();
            Customer customer = customerService.getCustomerById(customerId);
//            System.out.println(customerService.getCustomerById(customerId));
            if(customerService.getCustomerById(customerId)==null)
            {
            	System.out.println("!! Check Customer ID Again !!");
            }
            else {
	            for (int i = 0; i < orderCount; i++) {
	            System.out.println("Enter food item by ID:");
	
	            int foodItemId = scan.nextInt();
	           
	            FoodItem foodItem = foodItemService.getFoodItemById(foodItemId);
//	            System.out.println( foodItemService.getFoodItemById(foodItemId));
		            if(foodItemService.getFoodItemById(foodItemId)== null)
		            {
		            	System.out.println("!!Check Food Item ID Again!!");
		            }else
		            {
		            System.out.println("Enter quantity:");
		            int quantity =scan.nextInt();
		
		            Order order = new Order(0, customer, foodItem, quantity); 
		            orderService.addOrder(order);
		                            
		            System.out.println("Order has been Placed succussfully....");
		            System.out.println("Please Note Your Order ID : "+orderService.getOrderId());
		            System.out.println("Your Total Bill " +"For "+foodItem.getItemName()+" is :"+ (foodItemService.getPriceBYId(foodItemId)*quantity)+"rs");     
		            BillSum = BillSum+(foodItemService.getPriceBYId(foodItemId)*quantity);
		            System.out.println();
		            }
	              }
            }     
        if(BillSum !=0) {
        System.out.println("Total Bill : "+BillSum+"rs");
        System.out.println("Enjoy Your Food..Thank You For Ordering...!!!!");
        }
        System.out.println();       
	}
        		
	private void deleteCustomer() throws SQLException {
		scan.nextLine();
    	System.out.println("Enter Customer ID to delete : ");
    	int id = Integer.parseInt(scan.nextLine());
    	
    	customerService.deleteCustomer(id);
    	System.out.println("Customer Deleted Succussfully ...!");
	}

	private void updateCustomer() throws SQLException {
		scan.nextLine();
    	System.out.println("Enter Customer ID to Update : ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.print("Enter new name: ");
        String name = scan.nextLine();
        System.out.print("Enter new Location: ");
        String Location = scan.nextLine();
        System.out.print("Enter new Phone Number: ");
        String Phone_Num = scan.nextLine();
        
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setLocation(Location);
        customer.setPhone_Number(Phone_Num);
        
        customerService.updateCustomer(customer);
        
        System.out.println("Customer Updated Succussfully....");		
	}

	private void viewAllCustomer() throws SQLException {
		// 
    	List<Customer> customers = customerService.getAllCustomer();
    	System.out.println("\nCustomer List :");
    	System.out.println("---------------------------------------------------");
    	System.out.printf("%-3s %-12s %-15s %-10s\n","ID","Name","Location","Phone_Number");
    	System.out.println("---------------------------------------------------");
    	for(Customer customer : customers)
    	{
//    		System.out.println("ID :" +customer.getId()+"Name: " + customer.getName() +
//                    ", Location : " + customer.getLocation() + ", Phone Number: " + customer.getPhone_Number());		   		
    		System.out.printf("%-3s %-12s %-15s %-10s\n",customer.getId(),customer.getName(),customer.getLocation(),customer.getPhone_Number());
    	}
    	System.out.println("---------------------------------------------------");
	}

	private void AddCustomer() throws SQLException {
		// Adding Customer 
    	scan.nextLine();
    	System.out.println("Enter Name : ");
    	String name = scan.nextLine();
    	System.out.println("Location :");
    	String Location = scan.nextLine();
    	System.out.println("Phone Number :");
    	String Phone_Num = scan.nextLine();
    	Customer customer = new Customer();
    	customer.setName(name);
    	customer.setLocation(Location);
    	customer.setPhone_Number(Phone_Num);
    	customerService.addCustomer(customer);
    	System.out.println("New Customer has been Succussfully Added....");	
//    	System.out.println("Wants to an Order Something...:)");
    
	}
	
	private void registerCustomer() throws SQLException {
		// Adding Customer 
    	scan.nextLine();
    	System.out.println("Enter Your Name : ");
    	String name = scan.nextLine();
    	System.out.println("Location :");
    	String Location = scan.nextLine();
    	System.out.println("Phone Number :");
    	String Phone_Num = scan.nextLine();
    	Customer customer = new Customer();
    	customer.setName(name);
    	customer.setLocation(Location);
    	customer.setPhone_Number(Phone_Num);
    	customerService.addCustomer(customer);
    	System.out.println("Welcome to Our restaurant "+customer.getName()+", \nYou have been Succussfully Registered....");	
//    	System.out.println("Wants to an Order Something...:)");
    
	}

	private void showOrderMenu() {
		// Order CRUD
        System.out.println("1. Menu Card");
        System.out.println("2. Place Order");
        System.out.println("3. Cancel Order");
        System.out.println("4. View Your All Orders");
        System.out.println("5. Update Order");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");	
	}

	private void showAdminMenu() {
		// Customer CRUD
        System.out.println("1. Add Customer");
        System.out.println("2. View All Customer");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");
        System.out.println("5. Add Food Items");
        System.out.println("6. Delete Food Items");
        System.out.println("7. View All Food Items");
        System.out.println("8. View All Orders");
        System.out.println("9. View Order details By Customer ID ");
        System.out.println("10. View Quantity of Specific Order ID ");
        System.out.println("11. Cancel Order");
        System.out.println("12. Update Order by OrderID ");
        System.out.println("13. Exit");
        System.out.print("Enter your choice: ");
    }

}
