package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;


public interface CustomerDao{
	
	Customer getCustomerById(int id);
	List<Customer> getCustomers();
	int addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	int deleteCustomer(int id);
	
}



