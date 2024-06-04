package Services;

import java.sql.SQLException;
import java.util.List;

import DAO.CustomerDAO;
import Models.Customer;

public class CustomerService {
	
	private CustomerDAO customerDAO;
	
	public CustomerService()
	{
		customerDAO = new CustomerDAO();
	}
	
	public void addCustomer(Customer customer) throws SQLException
	{
		customerDAO.addCustomer(customer);
	}
	
	public List<Customer> getAllCustomer() throws SQLException
	{
		return customerDAO.getAllCustomer();
	}
	
    public void updateCustomer(Customer customer) throws SQLException 
    {
             customerDAO.updateCustomer(customer);
    }
    
    public void deleteCustomer(int id) throws SQLException 
    {
           customerDAO.deleteCustomer(id);
    }

	public Customer getCustomerById(int Id) throws SQLException {
		
		return customerDAO.getCustomerById(Id);
	
	}
	


}
