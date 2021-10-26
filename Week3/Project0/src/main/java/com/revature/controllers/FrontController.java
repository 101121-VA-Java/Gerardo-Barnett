package com.revature.controllers;

import java.util.Scanner;

public class FrontController {
	private Scanner sc; 
	private CustomerController cc;
	
	public FrontController() {
		sc = new Scanner(System.in);
		cc = new CustomerController();
	}
	
	public void run() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: Register");
			System.out.println("2: Login");
			System.out.println("3: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				cc.registerCustomer(sc);
				// TODO: if a customer is not registered, display a different message
				break;
			case 2:
				cc.loginCustomer(sc);
				break;
			case 3:
				run = false;
				break;
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		sc.close();
	}
}