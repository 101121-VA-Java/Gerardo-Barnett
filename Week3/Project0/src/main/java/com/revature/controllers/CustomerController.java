package com.revature.controllers;

import java.util.Scanner;

import com.revature.exceptions.LoginException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;
import com.revature.controllers.UserController;

public class CustomerController {

	private static CustomerService cs = new CustomerService();
    private static UserController um = new UserController();
    static Scanner sc = new Scanner(System.in);
    private static Customer principal;
	
	
//	public void searchForCustomer() {
//		scanner getting user input
//		try {
//			Customer c = cs.getCustomerById(0);
//		} catch (UserNotFoundException e) {
//			System.out.println("User doesn't exist.");
//			e.printStackTrace();
//		} 
//	}
	
	public void registerCustomer(Scanner scan) {
//		System.out.println("Please enter a Name: ");
//		String name = scan.nextLine();
//		while (name.trim().length() < 3) {
//			System.out.println("Please enter a Name longer than 2 characters: ");
//			name = scan.nextLine();
//		}
//		System.out.println("Please enter a Username: ");
//		String username = scan.nextLine();
//		while (username.trim().length() < 3) {
//			System.out.println("Please enter a Username longer than 2 characters: ");
//			username = scan.nextLine();
//		}
//		System.out.println("Please enter a Password: ");
//		String password = scan.nextLine();
//		while (password.trim().length() < 4) {
//			System.out.println("Please enter a Password longer than 3 characters: ");
//			password = scan.nextLine();
//		}
//		
//		System.out.println("Please enter a Card Number: ");
//		String cardNumber = scan.nextLine();
//		try {
//			while (cardNumber.trim().length() < 8) {
//				if (Integer.parseInt(cardNumber) < 9999999) {
//					System.out.println("Please enter a Card Number longer than 7 integers: ");
//					cardNumber = scan.nextLine();
//				}
//			}
//		} catch (Exception e) {
//			e.getStackTrace();
//			System.out.println(
//					"Please enter a Card Number longer than 7 integers and consists only of integers.\nPlease try again.\n");
//			return;
//		}
//
//
//		Customer newCustomer = new Customer(name, username, password, creditcard);
//
//		try {
//			cs.add(newCustomer);
//			
//			System.out.println("Customer " + username + " has been registered!\n");
//			
//		} catch (UsernameAlreadyExistsException e) {
//
//			System.out.println("Username is already in use.\nPlease try again.\n");
//		}
	}
	
	public static void loginCustomer() {

		System.out.println("Please enter your username:");
		String username = sc.nextLine();

		System.out.println("Please enter your password:");
		String password = sc.nextLine();
		System.out.println("Checking credentials");
		try {
			principal = cs.login(username, password);

		} catch (LoginException e) {
			System.out.println("Invalid credentials.");
			um.cMenu();
		}
		System.out.println("Logged in.");
		um.customerMenu();
		sc.close();

	}
	
	
	
	
}