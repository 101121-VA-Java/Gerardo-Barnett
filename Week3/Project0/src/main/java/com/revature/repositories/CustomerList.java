package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Customer;

public class CustomerList implements CustomerDao{

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
//		return 0;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getUser(String username) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
