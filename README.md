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
<li>Model: Contains classes that represent the data structure, such as Customer, FoodItem, and Order.</li>
<li>DAO (Data Access Object): Interfaces and their implementations for accessing and manipulating the database.</li>
<<li>li>Service: Business logic and operations involving multiple DAOs.</li>
<li>Main: Entry point of the application, demonstrating how to use the various components.</li>
<li>utility:</li>
</ol>

