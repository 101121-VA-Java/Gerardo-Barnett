package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerPostgres;

public class UserAuth {
	
	private CustomerDao cd;
	private CustomerPostgres cp;
	
	
	
	public UserAuth() {
		cp = new CustomerPostgres();
	}
	
	public String register(Customer c) {
		String created = "Sorry, something went wrong. Please try again.";
//		try {
//			cp.addCustomer(c);
//			return "true";
//		} 
//		catch(SQLException e){
//			if(e.getMessage().contains("duplicate key value")) {
//				return "Looks like you already have an account!";
//		}
//		} catch(IOException e) {
//		
//		}
		
		
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
				return "loggedin";
			}
			else { return "Invalid Password." ; }
			
		}
		else { return "Username does not exist.";}
		
		
		
		
		
	}
	

}
