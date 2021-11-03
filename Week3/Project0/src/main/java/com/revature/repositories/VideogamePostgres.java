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
	public int addVideogame(Videogame videogame) {
		int genId = -1;
		String sql = "insert into videogames (v_name, v_publisher, v_genre, v_price, v-quantity) "
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
		
		return genId;
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
	public int deleteVideogame(int id) {
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
		return rowsChanged;
	}

}
