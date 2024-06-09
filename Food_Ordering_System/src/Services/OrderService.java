package Services;

import java.sql.SQLException;
import java.util.List;

import DAO.OrderDAO;
import Models.Order;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public void addOrder(Order order) throws SQLException {
        orderDAO.addOrder(order);
    }

    public List<Order> getAllOrders() throws SQLException {
        return orderDAO.getAllOrders();
    }

    public Order getOrderById(int id) throws SQLException {
        return orderDAO.getOrderById(id);
    }

    public void updateOrder(Order order) throws SQLException {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(int id) throws SQLException {
        orderDAO.deleteOrder(id);
    }

	public int getOrderId() throws SQLException
	{
		return orderDAO.getOrderId();
	}
	
	public List<Order> getOrderDetailsByCustomerID(int customerid) throws SQLException
	{
		return orderDAO.getOrderDetailsByCustomerID(customerid);
	}

	public int getQuantityBYId(int id) throws SQLException
	{
		return orderDAO.getQuantityBYId(id);
	}
}

