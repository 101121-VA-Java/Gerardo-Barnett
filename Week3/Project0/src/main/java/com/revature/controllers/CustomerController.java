package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class CustomerController {

	private CustomerService cs = new CustomerService();
	
	public void searchForCustomer() {
		// scanner getting user input
		try {
			Customer c = cs.getCustomerById(0);
		} catch (UserNotFoundException c) {
			System.out.println("User doesn't exist.");
			c.printStackTrace();
		} 
	}
	
	public void registerCustomer(Scanner scan) {
		System.out.println("Please enter a name: ");
		String name = scan.nextLine();
		scan.nextLine();
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		
		
		
		Customer newCustomer = new Customer(name, username, password);
		
		// TODO: check whether a customer created or not (if the method works)
		cs.addCustomer(newCustomer);
		
		System.out.println("The customer has been registered");
		
		
	}
	
	public void loginCustomer(Scanner scan) {
		System.out.println("Please enter a username: ");
		String username = scan.nextLine();
		scan.nextLine();
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		
		boolean isLoggedIn = false;
		Customer validCustomer = new Customer(username, password);
		if(cs.customerList(username, password) != null) {
			isLoggedIn = true;
			System.out.println("Customer " + validCustomer.getUsername() + " has been logged in successfully");
		}
		
		if(!isLoggedIn) {
			System.out.println("Wrong username and password. Please try again");
		}
		
	}
	
	
}