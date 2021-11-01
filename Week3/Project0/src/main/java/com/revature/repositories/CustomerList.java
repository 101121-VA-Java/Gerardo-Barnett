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
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		
		for(Customer c : customers) {
			
			if(c.getId() == id) {
				return c;
			}
		}
		
		return null;
	}

	@Override
	public int add(Customer c) {
		// TODO Auto-generated method stub
		
		
		customers.add(c);
		
		return c.getId();
	}

	@Override
	public boolean edit(Customer c) {
		// TODO Auto-generated method stub
		Customer temp = getById(c.getId());
		if (temp == null || temp.equals(c)) {
			return false;
		}
		customers.set(c.getId(), c);
		return true;
		
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
