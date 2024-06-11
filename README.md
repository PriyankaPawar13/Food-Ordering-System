# <h1>Food Ordering System</h1>

<h3><b>Description :</b></h3> 
<p>
The Food Ordering System is a Java-based application designed to manage customer orders for a food delivery service. It provides functionality for customers to place orders, update existing orders, and view order details. The system uses a MySQL database to store information about customers, food items, and orders, ensuring data persistence and integrity.
</p>
<p>
This project is structured in a way that demonstrates the use of the Data Access Object (DAO) pattern, which abstracts and encapsulates all access to the data source, making it easier to manage database operations and improve maintainability. Additionally, the project follows a multi-layered architecture, separating concerns into different layers: Model, DAO, Utility and Service.
</p>

<h3>Key Features</h3>
<ul>
<li>Customer Management: Add, update,delete and retrieve customer details.</li>
<li>Food Item Management: Add, update,delete and retrieve food item details.</li>
<li>Order Management: Place new orders, update existing orders,delete existing orders and retrieve order details by customer ID.</li>
<li>Data Persistence: Uses MySQL for storing customer, food item, and order data.</li>
</ul>

<h3>Project Structure</h3>
<b></b>The project is organized into the following main components:</b>

<ol>
<li><b>Model:</b> Contains classes that represent the data structure, such as <b>`Customer`, `FoodItem`, </b>and<b> `Order`.</b></li>
<li><b>DAO (Data Access Object):</b> Interfaces and their implementations for accessing and manipulating the database.</li>
<li><b>Service:</b> Business logic and operations involving multiple DAOs.</li>
<li><b>Main:</b> Entry point of the application, demonstrating how to use the various components.</li>
<li><b>utility:</b> for DataBase Connection </li>
</ol>

<h3>Database Schema</h3>
<b>The database consists of three tables: Customer, FoodItem, and Order.</b>

<p><b>Customer Table :</b></p>

<table>
<tr >
  <th>Column</th>
  <th>Type</th>
  <th>Description</th>
</tr>
  <tr>
  <td></td>
  <td></td>
  <td></td>    
</tr>
</table>

<h3>Setup Instructions</h3>
<h2>Prerequisites</h2><ul>
<li>Java Development Kit (JDK) 8 or higher</li>
<li>MySQL Database  </li>
</ul>

<h3>Step-by-Step Setup</h3>
bash
<b>Clone the repository:</b>
<ul>
<li>Copy code</li>
<p>git clone https://github.com/yourusername/FoodOrderingSystem.git</p>
<p> cd FoodOrderingSystem</p>

<li>Create the database and tables:</li>
</p>
sql
<b>CREATE DATABASE FoodOrderingSystem;</b>
<p>
USE FoodOrderingSystem;

CREATE TABLE Customer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE FoodItem (
    itemId INT PRIMARY KEY AUTO_INCREMENT,
    itemName VARCHAR(100) NOT NULL,
    itemPrice DOUBLE NOT NULL
);

CREATE TABLE `Order` (
    orderId INT PRIMARY KEY AUTO_INCREMENT,
    customerId INT,
    foodItemId INT,
    quantity INT,
    FOREIGN KEY (customerId) REFERENCES Customer(id),
    FOREIGN KEY (foodItemId) REFERENCES FoodItem(itemId)
);

</p>
Configure the database connection:
Update the application.properties file with your database credentials:

properties
Copy code
jdbc.url=jdbc:mysql://localhost:3306/FoodOrderingSystem
jdbc.user=root
jdbc.password=yourpassword
Compile and run the application:

bash
Copy code
javac -d bin src/main/java/com/foodorderingsystem/Main.java


java -cp bin com.foodorderingsystem.Main

</ul>



