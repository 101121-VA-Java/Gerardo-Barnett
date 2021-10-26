package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerArray;


public class CustomerService {
	
private CustomerDao cd;


    public CustomerService() {
    	super();
    	cd = new CustomerArray();
    }
	
	public int addCustomer(Customer c) {
		/*
		 * add business logic here to manipulate e before storage
		 */
		return cd.addCustomer(c);
	}
	
	public Customer getCustomerById(int id) throws UserNotFoundException{

		if(id > 0) { // just for example's sake
		throw new UserNotFoundException();
		} 

		return null;
	}
	
	public Customer customerList(String username, String password) {
		
		int i = 0;
		Customer validCustomer = new Customer(username, password);
		for(Customer all : cd.getAllCustomers()) {
			if(validCustomer.getUsername().equals(all.getUsername()) && validCustomer.getPassword().equals(all.getPassword())) {
				return cd.getCustomerById(i);
			}
			i++;
		}
		return null;
	}

}
