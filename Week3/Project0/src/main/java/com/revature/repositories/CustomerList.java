package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;

public class CustomerList implements CustomerDao{

	private List<Customer> customers;
	
	public CustomerList() {
		customers = new ArrayList<>();
		
		
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		
		for(Customer c : customers) {
			
			if(c.getId() == id) {
				return c;
			}
		}
		
		return null;
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		c.setId(customers.size());
		
		customers.add(c);
		
		return c;
	}

	@Override
	public boolean editCustomer(Customer c) {
		// TODO Auto-generated method stub
		Customer temp = getCustomerById(c.getId());
		if (temp == null || temp.equals(c)) {
			return false;
		}
		customers.set(c.getId(), c);
		return true;
		
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
