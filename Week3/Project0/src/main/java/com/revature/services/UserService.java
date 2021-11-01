package com.revature.services;

import com.revature.models.Videogame;
import com.revature.models.Customer;
import com.revature.repositories.VideogameDao;
import com.revature.repositories.VideogameList;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerList;


public class UserService {
	
	private CustomerDao cd = new CustomerList();
	private VideogameDao bd = new VideogameList();

	public boolean newPayment(double payment) {
		return false;
	}

	public Videogame viewVideogame(int id) {
		return null;
	}
	
	public Videogame viewAllVideogames() {  
		return null;
		
	}

	public double newOffer(double offer) {
		return offer;
	}

	public void viewOtherPayments() { 

	}

	public boolean addVideogame(Videogame v) { 
		return false;

	}

	public boolean removeVideogame(Videogame v) { 
		return false;

	}

	public boolean reviewOffer() {  
		return false;

	}

	public void reviewAllPayments() { 

	}

	public boolean editVideogame(Videogame v) { 
		return false; 

	}

	public void salesHistory() { 

	}

	public Customer addEmployee(int id) {
		return null;
	}

}
