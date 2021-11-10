package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.models.Offer;
import com.revature.models.Videogame;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerPostgres;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;
import com.revature.repositories.VideogameDao;
import com.revature.repositories.VideogamePostgres;
import com.revature.services.UserAuth;
import com.revature.services.VideogameService;

public class UserController {
	
	InputValidator iv = new InputValidator();
	Scanner sc = new Scanner(System.in);
	private Scanner uc; 
	private CustomerController cc;
	private RegisterController rc;
	private VideogamePostgres vp;
	private UserAuth ua;
	private static EmployeePostgres ep;
	
	public UserController() {
		uc = new Scanner(System.in);
		cc = new CustomerController();
		rc = new RegisterController();
		ua = new UserAuth();
		vp = new VideogamePostgres();
		ep = new EmployeePostgres();
	}
	
	
	
	
	
	public void userMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome to Gerardo's Game n Trade store. Please select an option:");
			System.out.println("1: Customer");
			System.out.println("2: Employee");
			System.out.println("3: Manager");
			System.out.println("4: Exit");
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				cMenu();
				break;
			case 2:
				eMenu();
				break;
			case 3:
				mMenu();
				break;	
			case 4:
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
			cMenu();
			run = false;
		}
		else {
			validData = false;
			System.out.println(returnVal);
		}
		
		}
		
	}
	
	
	private void registerEmployee(Scanner sc) {
		boolean run = true;		
		boolean validData = false;
		String name = "";
		String username = "";
		String password = "";
		String role = "";
		int man_id = 0;
		while(run) {		
		while (!validData) {		
		System.out.println("Enter your name:");
		name = sc.nextLine();
		System.out.println("Enter your username:");
		username = sc.nextLine();
		System.out.println("Enter your password:");
		password = sc.nextLine();
		System.out.println("Enter your role:");
		role = sc.nextLine();
		System.out.println("Enter your manager id:");
		man_id = sc.nextInt();
		
		if ((username.length() < 4 && password.length() < 4)) {
		System.out.println("username & password must have at least 4 characters:");
		}
		else {
			validData = true;
		}
		}
		Employee e = new Employee(name, username, password, role, new Employee(man_id));
		UserAuth ua = new UserAuth();
		String returnVal = ua.registerE(e);
		if (returnVal == "true") {
			System.out.println("Employee has been created.");
			eMenu();
			run = false;
		}
		else {
			validData = false;
			System.out.println(returnVal);
		}
		
		}
		
	}
	
	private void registerEmployee2(Scanner sc) {
		boolean run = true;		
		boolean validData = false;
		String name = "";
		String username = "";
		String password = "";
		String role = "";
		int man_id = 0;
		while(run) {		
		while (!validData) {		
		System.out.println("Enter the name of the employee:");
		name = sc.nextLine();
		System.out.println("Enter the username of the employee:");
		username = sc.nextLine();
		System.out.println("Enter the password of the employee:");
		password = sc.nextLine();
		System.out.println("Enter the role of the employee:");
		role = sc.nextLine();
		System.out.println("Enter the manager id:");
		man_id = sc.nextInt();
		
		if ((username.length() < 4 && password.length() < 4)) {
		System.out.println("username & password must have at least 4 characters:");
		}
		else {
			validData = true;
		}
		}
		Employee e = new Employee(name, username, password, role, new Employee(man_id));
		UserAuth ua = new UserAuth();
		String returnVal = ua.registerE(e);
		if (returnVal == "true") {
			System.out.println("Employee has been created.");
			managerMenu();
			run = false;
		}
		else {
			validData = false;
			System.out.println(returnVal);
		}
		
		}
		
	}
	
	private void registerManager(Scanner sc) {
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
		
		
		if ((username.length() < 4 && password.length() < 4)) {
		System.out.println("username & password must have at least 4 characters:");
		}
		else {
			validData = true;
		}
		}
		Manager m = new Manager(name, username, password);
		UserAuth ua = new UserAuth();
		String returnVal = ua.registerM(m);
		if (returnVal == "true") {
			System.out.println("Manager has been created.");
			cMenu();
			run = false;
		}
		else {
			validData = false;
			System.out.println(returnVal);
		}
		
		}
		
	}
	
     private void loginCustomer(Scanner sc) {
		
		boolean run = true;
		String username = "";
		String password = "";
		while(run) {		
			System.out.println("Enter your username:");
			username = sc.nextLine();
			System.out.println("Enter your password:");
			password = sc.nextLine();
			UserAuth ua = new UserAuth();
			String authResult = ua.logIn(username, password);
			if (authResult.equals("Logged in successfully")) {
				customerMenu();
				run = false;
				System.out.println("Welcome " + Customer.currentCustomer.getName());
				
				
			}
			else {
				System.out.println(authResult);
			}
			
		}

		
	}
     
     private void loginEmployee(Scanner sc) {
 		
 		boolean run = true;
 		String username = "";
 		String password = "";
 		while(run) {		
 			System.out.println("Enter your username:");
 			username = sc.nextLine();
 			System.out.println("Enter your password:");
 			password = sc.nextLine();
 			UserAuth ua = new UserAuth();
 			String authResult = ua.logInE(username, password);
 			if (authResult.equals("Logged in successfully")) {
 				employeeMenu();
 				run = false;
 				System.out.println("Welcome " + Employee.currentEmployee.getName());
 				
 				
 			}
 			else {
 				System.out.println(authResult);
 			}
 			
 		}

 		
 	}
     
     private void loginManager(Scanner sc) {
  		
  		boolean run = true;
  		String username = "";
  		String password = "";
  		while(run) {		
  			System.out.println("Enter your username:");
  			username = sc.nextLine();
  			System.out.println("Enter your password:");
  			password = sc.nextLine();
  			UserAuth ua = new UserAuth();
  			String authResult = ua.logInM(username, password);
  			if (authResult.equals("Logged in successfully")) {
  				managerMenu();
  				run = false;
  				System.out.println("Welcome " + Manager.currentManager.getName());
  				
  				
  			}
  			else {
  				System.out.println(authResult);
  			}
  			
  		}

  		
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
				loginCustomer(sc);
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
				loginEmployee(sc);
				break;
			case 2:
				registerEmployee(sc);
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
	
	public void mMenu() {
		boolean run = true;
		
		while(run) {
			System.out.println("Welcome manager, please select an option:");
			System.out.println("1: Login");
			System.out.println("2: Register");
			System.out.println("3: Exit");
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				loginManager(sc);
				break;
			case 2:
				registerManager(sc);
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
			System.out.println("Welcome customer. Please select an option:");
			System.out.println("1: Make a payment");
			System.out.println("2: View items");
			System.out.println("3: Make offer for an item");
			System.out.println("4: View items owned");
			System.out.println("5: View remaining payments for items");
			System.out.println("6: Sign out");
			
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				
				break;
			case 2:
				VideogameDao vd = new VideogamePostgres();
				List<Videogame> vg = vd.getVideogames();
				for (Videogame v : vg) {
					System.out.println(v);
				}
				customerMenu();
				break;
			case 3:
				itemsMenu(sc);
				break;
			case 4:
				viewOwnedItems(sc);
				break;
			case 5:
				viewRemainingPayment(sc);
				break;
            case 6:
            	System.out.println("Thank you for stopping by at Gerardo's Game n Trade store. Have a nice day.");	
            	userMenu();
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
			System.out.println("Welcome Employee. Please select an option:");
			System.out.println("1: Add an item");
			System.out.println("2: Accept/Reject offer of an item");
			System.out.println("3: Remove an item");
			System.out.println("4: View payment");
			System.out.println("5: Sign out");
			
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				addVideogame(sc);
				break;
			case 2:
				approveOffers(sc);
				break;
			case 3:
				deleteVideogame(sc);
				break;
			case 4:
				viewPayments(sc);
				break;
			case 5:
				System.out.println("Thank you for stopping by at Gerardo's Game n Trade store. Have a nice day.");	
            	userMenu();
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
			System.out.println("Welcome Manager. Please select an option:");
			System.out.println("1: Create an employee account");
			System.out.println("2: Delete an employee");
			System.out.println("3: View customer accounts");
			System.out.println("4: View employee accounts");
			System.out.println("5: Sign out");
			
			
			
			int option = uc.nextInt();
			
			switch(option) {
			case 1:
				registerEmployee2(sc);
				break;
			case 2:
				
				
				break;
			case 3:
                CustomerDao cd = new CustomerPostgres();
 				
 				List<Customer> cs = cd.getCustomers();
 				for (Customer c : cs) {
 					System.out.println(c);
 						}
 				managerMenu();
				break;
            case 4:
            	EmployeeDao ed = new EmployeePostgres();
 				
 				List<Employee> es = ed.getEmployees();
 				for (Employee e : es) {
 					System.out.println(e);
 						}
 				managerMenu();
				break;
            case 5:
            	System.out.println("Thank you for stopping by at Gerardo's Game n Trade store. Have a nice day.");	
            	userMenu();
				break;
            
			
			default:
				System.out.println("Invalid input. Please try again");
			}
		}
		
		uc.close();
	}
	
	
	private void viewOwnedItems(Scanner sc) {
		VideogameService vg = new VideogameService();
		vg.viewOwnedItems(Customer.currentCustomer.getId());
	}
	private void viewRemainingPayment(Scanner sc) {
		VideogameService vg = new VideogameService();
		vg.viewOwnedPayments(Customer.currentCustomer.getId());
		
		
	}
	
		private void itemsMenu(Scanner sc) {
		
		VideogameService li = new VideogameService();
		ArrayList<Videogame> listvg = li.getItems();
		if (listvg.size() != 0) {
			for (Videogame i : listvg) {
				System.out.println(i);
			}
			
			System.out.println("Would you like to make an offer? ");
			boolean continueOffer = iv.validateBoolean(sc);
			
			if (continueOffer) {
			System.out.println("Please select the videogame id to make offer for :");
			int itemNum = iv.validateInt(sc);
			//sc.nextLine();
			System.out.println("Please enter the amount you would like to offer for the item:");
			double itemPrice = iv.validateDouble(sc);
			sc.nextLine();
			
			VideogameService i = new VideogameService();
			i.makeOffer(Customer.currentCustomer, itemNum, itemPrice);
			
		}
		else {
			System.out.println("No items have been added to the shop yet.");
		}
		}
	
}
		

		
	
	private void addVideogame(Scanner sc) {		
		
		
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter publisher");
		String publisher = sc.nextLine();	
		System.out.println("Enter genre");
		String genre = sc.nextLine();
		System.out.println("Enter price");
		Double price = sc.nextDouble();
		System.out.println("Enter quantity");
		int quantity = sc.nextInt();				
		Videogame g = new Videogame(name, publisher, genre, price, quantity);		
		VideogameService vg = new VideogameService();
		if (
		vg.addVideogame(g)
		== false) {
			System.out.println("Could not add videogame");
		}
		else {
			System.out.println("Videogame added to the shop");
		}
			
	}
	
//	public static void deleteEmployee(Scanner sc) {
//		System.out.println("Input the id of the employee you want to remove:");
//		int id = sc.nextInt();
//		sc.nextLine();
//		Employee i = new Employee(id);
//		i = ep.deleteEmployee(i);
//		System.out.println("Successfully Removed Item.");	
//		if(i != null) {
//			System.out.println("Something went wrong");
//		}
//		
//	}

	private void approveOffers(Scanner sc) {		
		VideogameService videogame = new VideogameService();
		ArrayList<Offer> listOffers = videogame.getPendingOffers();
		if (listOffers.size() != 0) {
			
		System.out.println("Select offer id to approve/reject");
		int o_id = iv.validateInt(sc);
		sc.nextLine();
		System.out.println("Approve Offer? : please enter yes or no");
		boolean approval = iv.validateBoolean(sc);		
		if ( approval) {
			for (Offer o : listOffers) {
				if (o.getV_id() == o_id) {
					videogame.changeOfferStatus(o_id, true, o.getV_id());
				}
			}
			
		}
		}
		else {
			System.out.println("No offers have been made for any items by customers.");
		}
		
	}

	//TODO : Solve foreign key constraint
	private void deleteVideogame(Scanner sc) {		
		
		VideogameService li = new VideogameService();
		ArrayList<Videogame> listitems = li.getItems();
		if (listitems.size() != 0) {			
			for (Videogame i : listitems) {				
				System.out.println(i);
			}
			
			System.out.println("Please select v_id to delete");
			int itemNum = iv.validateInt(sc);
			sc.nextLine();
			VideogamePostgres item = new VideogamePostgres();
			item.deleteVideogame(itemNum);
			System.out.println("Videogame deleted");
		}
		else {
			System.out.println("No videogames found.");
		}
		
	}

	private void viewPayments(Scanner sc) {		
		
		VideogameService li = new VideogameService();
		li.viewAllPayments();
	}	
	



	
	/*
	 * System
	 * - update item to an owned state when an offer is accepted
	 * - Reject pending offers for an item when an offer is accepted
	 * - Calculate weekly payment
	 */
	
	

}
