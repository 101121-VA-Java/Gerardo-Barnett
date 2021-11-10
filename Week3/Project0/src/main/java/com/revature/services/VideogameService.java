package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.revature.models.Videogame;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Customer;
import com.revature.repositories.VideogamePostgres;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VideogameService {
	
	private static Logger log = LogManager.getRootLogger();
	private VideogamePostgres id;
	
	
	public VideogameService() {
		id = new VideogamePostgres();
	}
	
	public boolean addVideogame(Videogame v) {
		
//		try {
//			id.addVideogame(v);
//		} catch (SQLException e) {
//			log.fatal("An error ocurred while trying to add a videogame.");
//			e.printStackTrace();
//			return false;
//		}
//		catch (IOException e) {
//			log.fatal("An error ocurred while trying to add videogame.");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return true;		
	}
	public ArrayList<Videogame> getItems() {
		
		
		try {				
			return id.viewItems();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to get a videogame.");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to get a videogame.");
			e.printStackTrace();
		}
		
		return null;		
	}
	
	public void makeOffer(Customer c, int v_id, double v_price) {
		try {
			id.makeOffer(c, v_id, v_price);
			System.out.println("Offer made successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not make an offer.");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to make an offer.");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Offer> getPendingOffers() {
		try {
			displayListOffers(id.getPendingOffers());	
			
			return id.getPendingOffers();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to get pending offer.");
			e.printStackTrace();
		}
		return null;
	}
	
	public void changeOfferStatus(int o_id, boolean approval, int v_id) {
		try {
			id.changeOfferStatus(o_id, approval, v_id);
			System.out.println("Videogame status changed");
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to change offer status.");
			e.printStackTrace();
		}
	}
	public void deleteVideogame(int v_id) throws IOException, SQLException  {
		id.deleteVideogame(v_id);
	}
	
		
	
	public void viewOwnedItems(int c_id) {
		try {				
			displayListItems(id.viewOwnedItems(c_id));		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to view owned videogames.");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to view owned videogame.");
			e.printStackTrace();
		}		

	}
	//TODO: if null, print no payments
	public void viewAllPayments() {
		try {
			displayListPayments(id.viewAllPayments());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to view all payments.");
			e.printStackTrace();
		}
	}
	
	public void calculateWeeklyPayment() {
		try {
			displayWeeklyPayment(id.getWeeklyPayments());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to calculate weekly payment.");
			e.printStackTrace();
		}
	}
	
	//TODO: if null, print no payments
	public void viewOwnedPayments(int c_id) {
		try {
			displayListPayments(id.viewOwnedPayments(c_id));
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			log.fatal("An error ocurred while trying to view owned payment.");
			e.printStackTrace();
		}
	}
	
	public void displayListItems(ArrayList<Videogame> list) {
		int numLooped = 0;
		for (Videogame i : list) {
			System.out.println(i);
			numLooped++;
		}
		if (numLooped == 0) {
			System.out.println("0 Items to display");
		}
	}
	public void displayListPayments(ArrayList<Payment> list) {
		int numLooped = 0;
		for (Payment i : list) {
			System.out.println(i);
			numLooped++;
		}
		if (numLooped == 0) {
			System.out.println("0 Items to display");
		}
		
	}
	public void displayListOffers(ArrayList<Offer> list) {
		int numLooped = 0;
		for (Offer i : list) {
			System.out.println(i);
			numLooped++;
		}
		if (numLooped == 0) {
			System.out.println("0 Items to display");
		}
	}
	public void displayWeeklyPayment(ArrayList<Offer> list) {
		double sales = 0;;
		for (Offer i : list) {
			sales += i.getOffer();			
		}
		System.out.println("Total of $" + sales + " sales in past 7 days.");

	}

}
