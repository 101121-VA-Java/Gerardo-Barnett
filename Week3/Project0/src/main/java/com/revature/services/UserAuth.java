package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.controllers.UserController;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Manager;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerPostgres;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;
import com.revature.repositories.ManagerDao;
import com.revature.repositories.ManagerPostgres;


public class UserAuth {
	
	private CustomerDao cd;
	private ManagerDao md;
	private EmployeeDao ed;
	private CustomerPostgres cp;
	private UserController uc;
	private ManagerPostgres mp;
	private EmployeePostgres ep;
	
	
	
	public UserAuth() {
		cp = new CustomerPostgres();
	    mp = new ManagerPostgres();
		ep = new EmployeePostgres();
	}
	
	public String register(Customer c) {
		String created = "Sorry, something went wrong. Please try again.";
		try {
			cp.addCustomer(c);
			return "true";
		} catch(SQLException e) {
			if(e.getMessage().contains("duplicate key value")) {
				return "Looks like you already have an account!";
		}

		} catch(IOException e) {
		
		}
		return created;
		}
	
	public String registerE(Employee em) {
		String created = "Sorry, something went wrong. Please try again.";
		try {
			ep.addEmployee(em);
			return "true";
		} catch(SQLException e) {
			if(e.getMessage().contains("duplicate key value")) {
				return "Looks like you already have an account!";
		}

		} catch(IOException e) {
		
		}
		return created;
		}
	
	public String registerE2(Employee em) {
		String created = "Sorry, something went wrong. Please try again.";
		try {
			ep.addEmployee(em);
			return "true";
		} catch(SQLException e) {
			if(e.getMessage().contains("duplicate key value")) {
				return "Looks like you already have an account!";
		}

		} catch(IOException e) {
		
		}
		return created;
		}
		
	
	public String registerM(Manager m) {
		String created = "Sorry, something went wrong. Please try again.";
		try {
			mp.addManager(m);
			return "true";
		} catch(SQLException e) {
			if(e.getMessage().contains("duplicate key value")) {
				return "Looks like you already have an account!";
		}

		} catch(IOException e) {
		
		}
		return created;
		}
	
	
		
	public String logIn(String username, String password) {

		Customer loggedUser = null;
		
		try {
			loggedUser = cp.getUser(username);
		} catch (SQLException e) {
			return "Something went wrong";
		}
		catch (IOException e) {				
			if (e.getMessage().contains("duplicate key value")) {
				return "User already exists";
				}			
		}
		// user exists, but still need to check if password match.
		if (loggedUser != null) {
			if (loggedUser.getPassword().equals(password)) {
				Customer.currentCustomer = loggedUser;
				return "Logged in successfully";
			}
			else { return "Invalid Password." ; }
			
		}
		else { return "Username does not exist.";}
		
		
	}
	
	public String logInE(String username, String password) {

		Employee loggedUser = null;
		
		try {
			loggedUser = ep.getUser(username);
		} catch (SQLException e) {
			return "Something went wrong";
		}
		catch (IOException e) {				
			if (e.getMessage().contains("duplicate key value")) {
				return "User already exists";
				}			
		}
		// user exists, but still need to check if password match.
		if (loggedUser != null) {
			if (loggedUser.getPassword().equals(password)) {
				Employee.currentEmployee = loggedUser;
				return "Logged in successfully";
			}
			else { return "Invalid Password." ; }
			
		}
		else { return "Username does not exist.";}
		
	
	}
	
	public String logInM(String username, String password) {

		Manager loggedUser = null;
		
		try {
			loggedUser = mp.getUser(username);
		} catch (SQLException e) {
			return "Something went wrong";
		}
		catch (IOException e) {				
			if (e.getMessage().contains("duplicate key value")) {
				return "User already exists";
				}			
		}
		// user exists, but still need to check if password match.
		if (loggedUser != null) {
			if (loggedUser.getPassword().equals(password)) {
				Manager.currentManager = loggedUser;
				return "Logged in successfully";
			}
			else { return "Invalid Password." ; }
			
		}
		else { return "Username does not exist.";}
		
	
	}
	

}
