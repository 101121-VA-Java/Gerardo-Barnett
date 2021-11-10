package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.Videogame;

public class VideogameList implements VideogameDao{

	@Override
	public Videogame getVideogameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videogame> getVideogames() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public int addVideogame(Videogame videogame) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public boolean updateVideogame(Videogame videogame) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public int deleteVideogame(int id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public ArrayList<Offer> getPendingOffers() throws IOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeOfferStatus(int o_id, boolean approval, int v_id) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Payment> viewAllPayments() throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Videogame> viewOwnedItems(int c_id) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Videogame> viewUnapprovedItems() throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeOffer(Customer c, int v_id, double price) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Payment> viewOwnedPayments(int c_id) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rejectAllOffers(int v_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addVideogame(Videogame videogame) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVideogame(int v_id) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Videogame> viewItems() throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Offer> getWeeklyPayments() throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
