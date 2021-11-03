package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;
import com.revature.controllers.UserController;

public class CustomerController {

//	private CustomerService cs = new CustomerService();
//	private UserController um = new UserController();
//	
//	public void searchForCustomer() {
//		// scanner getting user input
//		try {
//			Customer c = cs.getCustomerById(0);
//		} catch (UserNotFoundException e) {
//			System.out.println("User doesn't exist.");
//			e.printStackTrace();
//		} 
//	}
//	
//	public void registerCustomer(Scanner scan) {
//		System.out.println("Please enter a name: ");
//		String name = scan.nextLine();
//		scan.nextLine();
//		System.out.println("Please enter a username: ");
//		String username = scan.nextLine();
//		
//		System.out.println("Please enter a password: ");
//		String password = scan.nextLine();
//		
//		
//		
//		Customer nc = new Customer(name, username, password);
//		
//		// TODO: check whether a customer created or not (if the method works)
//		try {
//			cs.addCustomer(nc);
//		} catch (UsernameAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("The customer has been registered");
//		
//		
//	}
//	
//	public void loginCustomer(Scanner scan) {
//		System.out.println("Please enter a username: ");
//		String username = scan.nextLine();
//		scan.nextLine();
//		System.out.println("Please enter a password: ");
//		String password = scan.nextLine();
//		
//		boolean isLoggedIn = false;
//		Customer validCustomer = new Customer(username, password);
//		if(cs.customerList(username, password) != null) {
//			isLoggedIn = true;
//			System.out.println("Customer " + validCustomer.getUsername() + " has been logged in successfully");
//		}
//		
//		if(!isLoggedIn) {
//			System.out.println("Wrong username and password. Please try again");
//		}
//		
//	}
//	
//	
	
	
}