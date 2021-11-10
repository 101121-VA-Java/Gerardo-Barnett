package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Videogame;
import com.revature.models.Customer;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.util.ConnectionUtil;

public class VideogamePostgres implements VideogameDao{
	
	@Override
	public Videogame getVideogameById(int id) {
		String sql = "select * from videogames where v_id = ? ";
		Videogame vg = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); // 1 refers to the first '?'	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int v_id = rs.getInt("v_id");
				String v_name = rs.getString("v_name");
				String v_publisher = rs.getString("v_publisher");
				String v_genre = rs.getString("v_genre");
				Double v_price = rs.getDouble("v_price");
				int v_quantity = rs.getInt("v_quantity");
				
				vg = new Videogame(v_id, v_name, v_publisher, v_genre, v_price, v_quantity);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return vg;
	}

	public List<Videogame> getVideogames() {
		String sql = "select * from videogames;";
		List<Videogame> videogames = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int v_id = rs.getInt("v_id");
				String v_name = rs.getString("v_name");
				String v_publisher = rs.getString("v_publisher");
				String v_genre = rs.getString("v_genre");
				Double v_price = rs.getDouble("v_price");
				int v_quantity = rs.getInt("v_quantity");
				
				Videogame newVG = new Videogame(v_id, v_name, v_publisher, v_genre, v_price, v_quantity);
				videogames.add(newVG);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videogames;
	}

	@Override
	public void addVideogame(Videogame videogame) {
		int genId = -1;
		String sql = "insert into videogames (v_name, v_publisher, v_genre, v_price, v_quantity) "
				+ "values (?, ?, ?, ?, ?) returning v_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, videogame.getName());
			ps.setString(2, videogame.getPublisher());
			ps.setString(3, videogame.getGenre());
			ps.setDouble(4, videogame.getPrice());
			ps.setInt(5, videogame.getQuantity());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("v_id");
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return genId;
	}

	@Override
	public boolean updateVideogame(Videogame videogame) {
		String sql = "update Videogames set v_name = ?, v_publisher = ?, v_genre = ?, v_price = ?, v_quantity = ? "
				+ "where v_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, videogame.getName());
			ps.setString(2, videogame.getPublisher());
			ps.setString(3, videogame.getGenre());
			ps.setDouble(4, videogame.getPrice());
			ps.setInt(5, videogame.getQuantity());
			ps.setInt(6, videogame.getId());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteVideogame(int id) {
		String sql = "delete from videogames where v_id = ?;";
		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			// if 1 is returned, indicates that 1 record was successfully deleted from the
			// table
			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return rowsChanged;
	}

	@Override
	public ArrayList<Offer> getPendingOffers() throws IOException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from offers where o_accepted = 'false';" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Offer> offersAL = new ArrayList<Offer>();
		while ( rs.next() ) {		
			Offer o = new Offer(rs.getInt("o_id"), rs.getInt("c_d"),
					rs.getInt("v_id"), rs.getDouble("offer"), rs.getBoolean("o_accepted"),
					rs.getBoolean("o_payment"));
		
			offersAL.add(o);			
		}
		return offersAL;
	}

	@Override
	public void changeOfferStatus(int o_id, boolean approval, int v_id) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "update offers set o_accepted = ? "
				+ "where o_id = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setBoolean(1, approval);	
		ps.setInt(2, o_id);
		ps.executeUpdate();
		if (approval) {
			String sql2 = "delete from offers where v_id = ? and o_acccepted = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, v_id);
			ps2.setBoolean(2, false);
			ps2.executeUpdate();
		}
	}

	@Override
	public ArrayList<Payment> viewAllPayments() throws SQLException, IOException {
		// TODO Auto-generated method stub
		
        Connection conn = ConnectionUtil.getConnectionFromFile();		
		String sql = "select * from offers o join customers c on o.c_id "
				+ "=c.c_id join videogames v on v.v_id  = o.v_id;" ;		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Payment> items = new ArrayList<Payment>();
		while ( rs.next() ) {	
			Payment i = new Payment(rs.getInt("p_id"), rs.getInt("v_id"), rs.getInt("c_id"),
					rs.getInt("o_id"), rs.getBoolean("paymentMade"));			
			items.add(i);			
		}
		
		return items;
	}

	@Override
	public ArrayList<Videogame> viewOwnedItems(int c_id) throws SQLException, IOException {
		// TODO Auto-generated method stub
        Connection conn = ConnectionUtil.getConnectionFromFile();
		
		String sql = "select distinct v_name, v_publisher, v_genre,"
				+ "v.v_price ,v.v_quantity, v.v_id from "
				+ "videogames v join offers o on o.c_id =" + c_id +  "where o.o_accepted = true;" ;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Videogame> items = new ArrayList<Videogame>();
		while ( rs.next() ) {			
			Videogame v = new Videogame(rs.getString("v_name"), rs.getString("v_publisher"),
					rs.getString("v_genre"), rs.getDouble("v_price"), rs.getInt("v_quantity"));
			v.setId(rs.getInt("itemid"));
			items.add(v);			
		}
		
		return items;
	}

	@Override
	public ArrayList<Videogame> viewUnapprovedItems() throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM ITEMS WHERE;" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Videogame> videogames = new ArrayList<Videogame>();
		while ( rs.next() ) {			
			Videogame v = new Videogame(rs.getString("v_name"), rs.getString("v_publisher"), rs.getString("v_genre"), 
					rs.getDouble("v_price"), rs.getInt("v_quantity") );
			v.setId(rs.getInt("v_id"));
			videogames.add(v);			
		}
		
		return videogames;
	}

	@Override
	public void makeOffer(Customer c, int v_id, double price) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "insert into offers(c_id, v_id, offer) values"
				+ "  ( ?, ?, ? );";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,c.getId() );
		ps.setInt(2, v_id);
		ps.setDouble(3, price );
		ps.executeUpdate();
		
	}

	@Override
	public ArrayList<Payment> viewOwnedPayments(int c_id) throws SQLException, IOException {
		// TODO Auto-generated method stub
        Connection conn = ConnectionUtil.getConnectionFromFile();		
		String sql = "select * from offers o join customers c on o.c_id"
				+ " =c.c_id join videogames v on v.v_id  = o.v_id where o.o_payment = false;" ;
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		ArrayList<Payment> items = new ArrayList<Payment>();
		while ( rs.next() ) {	
			Payment i = new Payment(rs.getInt("p_id"), rs.getInt("v_id"), rs.getInt("c_id"),
					rs.getInt("o_id"), false);			
			items.add(i);			
		}
		
		return items;
	}
	
	@Override
	public ArrayList<Offer> getWeeklyPayments() throws SQLException, IOException {
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "SELECT * FROM USER_OFFERS where payment_made = 'true'"
				+ " and date_created > DATE(NOW()) - INTERVAL '7' DAY ;" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Offer> offersAL = new ArrayList<Offer>();
		while ( rs.next() ) {		
			Offer o = new Offer(rs.getInt("o_id"), rs.getInt("c_id"),
					rs.getInt("v_id"), rs.getDouble("offer"), rs.getBoolean("o_accepted"),
					rs.getBoolean("o_payment"));
			
			offersAL.add(o);			
		}
		return offersAL;
	}

	@Override
	public boolean rejectAllOffers(int v_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Videogame> viewItems() throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
