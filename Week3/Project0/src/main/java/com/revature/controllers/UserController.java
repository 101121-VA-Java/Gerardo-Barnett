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
			System.out.println("3: Remove an item");
			System.out.println("4: View payment");
			
			
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
			System.out.println("2: Fire employee");
			System.out.println("3: View sales history of all offers");
			
			
			
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
	
	/*
	 * System
	 * - update item to an owned state when an offer is accepted
	 * - Reject pending offers for an item when an offer is accepted
	 * - Calculate weekly payment
	 */

}
