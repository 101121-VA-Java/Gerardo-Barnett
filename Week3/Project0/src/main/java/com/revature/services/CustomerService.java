package com.revature.services;

import java.util.List;

import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerList;


public class CustomerService {
	
	private static CustomerDao cd = new CustomerList();

	public int addCustomer(Customer c) throws UsernameAlreadyExistsException {

		Customer nc = this.getCustomerByUsername(c.getUsername());
		if (nc != null) {
			throw new UsernameAlreadyExistsException();
		}

		return cd.add(c);
	}

	public Customer getCustomerByUsername(String username) {
		List<Customer> customers = cd.getAll();
		for (Customer c : customers) {
			if (c.getUsername().equals(username)) {
				return c;
			}
		}
		return null;
	}
	
	public Customer getCustomerById(int id) {
		List<Customer> customers = cd.getAll();
		for (Customer c : customers) {
			if (c.getUsername().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public Customer login(String username, String password) throws LoginException {
		Customer c = this.getCustomerByUsername(username);
		if (c == null || !c.getPassword().equals(password)) {
			throw new LoginException();
		}
		return c;
	}
	
	public Customer customerList(String username, String password) {
		int i = 0;
		Customer validCustomer = new Customer(username, password);
		for (Customer all : cd.getAll()) {
			if (validCustomer.getUsername().equals(all.getUsername())
					&& validCustomer.getPassword().equals(all.getPassword())) {
				return cd.getById(i);
			}
			i++;
		}
		return null;
	}

}
