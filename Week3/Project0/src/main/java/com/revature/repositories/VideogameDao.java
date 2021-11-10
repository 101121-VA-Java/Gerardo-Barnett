package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Videogame;

public interface VideogameDao{
	
	Videogame getVideogameById(int id);
	List<Videogame> getVideogames();
	void addVideogame(Videogame videogame) throws IOException, SQLException;
	boolean updateVideogame(Videogame videogame);
	void deleteVideogame(int v_id) throws IOException, SQLException;
	ArrayList<Videogame> viewItems() throws SQLException, IOException;
	
	//Employee
	
	ArrayList<Offer> getPendingOffers() throws IOException, SQLException;
	void changeOfferStatus(int o_id, boolean approval, int v_id) throws SQLException, IOException;
	ArrayList<Payment> viewAllPayments() throws SQLException, IOException;
	
    //Customer
	ArrayList<Videogame> viewOwnedItems(int c_id) throws SQLException, IOException;
	ArrayList<Videogame> viewUnapprovedItems() throws SQLException, IOException;
	void makeOffer(Customer c, int v_id, double price) throws SQLException, IOException;
	ArrayList<Payment> viewOwnedPayments(int c_id) throws SQLException, IOException;
	ArrayList<Offer> getWeeklyPayments() throws SQLException, IOException;
	
	//System
	boolean rejectAllOffers(int v_id);
	
}
