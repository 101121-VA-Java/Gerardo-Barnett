package com.revature.controllers;

import java.util.Scanner;

public class UserController {
	
	private Scanner uc; 
	private CustomerController cc;
	private RegisterController rc;
	
	public UserController() {
		uc = new Scanner(System.in);
		cc = new CustomerController();
		rc = new RegisterController();
	}
	
	public void userMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: Customer");
			System.out.println("2: Employee");
			System.out.println("3: Exit");
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
					
				break;		
			
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		uc.close();
	}
	
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
				
				break;
			case 2:
				
				break;
            case 3:
				
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
