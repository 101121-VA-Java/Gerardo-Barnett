package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.services.UserAuth;

public class UserController {
	
	Scanner sc = new Scanner(System.in);
	private Scanner uc; 
	private CustomerController cc;
	private RegisterController rc;
	private UserAuth ua;
	
	public UserController() {
		uc = new Scanner(System.in);
		cc = new CustomerController();
		rc = new RegisterController();
		ua = new UserAuth();
	}
	
	
	
	
	
	public void userMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome to Gerardo's Game n Trade store. Please select an option:");
			System.out.println("1: Customer");
			System.out.println("2: Employee");
			System.out.println("3: Exit");
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				cMenu();
				break;
			case 2:
				eMenu();
				break;
			case 3:
				System.out.println("Thank you for stopping by at Gerardo's Game n Trade store. Have a nice day.");	
				break;		
			
			default:
				System.out.println("Invalid input. Please try again");
				userMenu();
				break;
			}
		}
		
		uc.close();
	}
	
	private void registerCustomer(Scanner sc) {
		boolean run = true;		
		boolean validData = false;
		String name = "";
		String username = "";
		String password = "";
		int creditcard = 0;
		while(run) {		
		while (!validData) {		
		System.out.println("Enter your name:");
		name = sc.nextLine();
		System.out.println("Enter your username:");
		username = sc.nextLine();
		System.out.println("Enter your password:");
		password = sc.nextLine();
		System.out.println("Enter your credit card:");
		creditcard = sc.nextInt();
		
		if ((username.length() < 4 && password.length() < 4)) {
		System.out.println("username & password must have at least 4 characters:");
		}
		else {
			validData = true;
		}
		}
		Customer c = new Customer(name, username, password, creditcard);
		UserAuth ua = new UserAuth();
		String returnVal = ua.register(c);
		if (returnVal == "true") {
			System.out.println("Customer has been created.");
			customerMenu();
			run = false;
		}
		else {
			validData = false;
			System.out.println(returnVal);
		}
		
		}
		
	}
	
//     private void loginCustomer(Scanner sc) {
//		
//		boolean run = true;
//		String username = "";
//		String password = "";
//		while(run) {		
//			System.out.println("Enter your username:");
//			username = sc.nextLine();
//			System.out.println("Enter your password:");
//			password = sc.nextLine();
//			UserAuth ua = new UserAuth();
//			String authResult = ua.logIn(username, password);
//			if (authResult.equals("logged in")) {
//				run = false;
//				System.out.println("Welcome " + Customer.currentCustomer.getName());
//				customerMenu();
//				
//			}
//			else {
//				System.out.println(authResult);
//			}
//			
//		}
//
//		
//	}
	
	
	public void cMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome customer, please select an option:");
			System.out.println("1: Login");
			System.out.println("2: Register");
			System.out.println("3: Exit");
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				cc.loginCustomer();
				break;
			case 2:
				registerCustomer(sc);
				break;
            case 3:
            	System.out.println("Thank you for stopping by at Gerardo's Game n Trade store. Have a nice day.");	
            	userMenu();
            	break;
			
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		uc.close();
	}
	
	public void eMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome employee, please select an option:");
			System.out.println("1: Login");
			System.out.println("2: Register");
			System.out.println("3: Exit");
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				
				break;
			case 2:
				
				break;
            case 3:
            	System.out.println("Thank you for stopping by at Gerardo's Game n Trade store. Have a nice day.");	
            	userMenu();
				break;	
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		uc.close();
	}
	
	
	public void customerMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: Make a payment");
			System.out.println("2: View items");
			System.out.println("3: Make offer for an item");
			System.out.println("4: View items owned");
			System.out.println("5: View remaining payments for items");
			
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				
				break;
			case 2:
				
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		uc.close();
	}
	
	public void employeeMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: Add an item");
			System.out.println("2: Accept/Reject offer of an item");
			System.out.println("3: Update an item");
			System.out.println("4: Remove an item");
			System.out.println("5: View payment");
			System.out.println("6: Sign out");
			
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				
				break;
			case 2:
				
				
				break;
			case 3:
				run = false;
				break;
			case 4:
				run = false;
				break;
			case 5:
				run = false;
				break;
			case 6:
				run = false;
				break;	
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		uc.close();
	}
	
	public void managerMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: Create an employee account");
			System.out.println("2: Update an employee");
			System.out.println("3: Delete an employee");
			System.out.println("4: View sales history of all offers");
			System.out.println("5: Sign out");
			
			
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				
				break;
			case 2:
				
				
				break;
			case 3:
				
				break;
            case 4:
				
				break;
            case 5:
				
				break;	
			
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		uc.close();
	}
	
	/*
	 * System
	 * - update item to an owned state when an offer is accepted
	 * - Reject pending offers for an item when an offer is accepted
	 * - Calculate weekly payment
	 */

}
