package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Customer;


public interface CustomerDao{
	
	Customer getCustomerById(int id);
	List<Customer> getCustomers();
	void addCustomer(Customer customer) throws SQLException, IOException;
	boolean updateCustomer(Customer customer);
	int deleteCustomer(int id);
	Customer getUser(String username) throws SQLException, IOException;
	
}



