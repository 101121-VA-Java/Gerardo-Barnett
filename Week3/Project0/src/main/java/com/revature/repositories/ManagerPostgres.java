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

import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.Customer;
import com.revature.models.Manager;
import com.revature.util.ConnectionUtil;

public class ManagerPostgres implements ManagerDao{
	
	@Override
	public Manager getManagerById(int id) {
		String sql = "select * from managers where m_id = ? ";
		Manager ms = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); // 1 refers to the first '?'	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int m_id = rs.getInt("m_id");
				String m_name = rs.getString("m_name");
				String m_username = rs.getString("m_username");
				String m_password = rs.getString("m_password");
				
				
				
				ms = new Manager(m_id, m_name, m_username, m_password);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return ms;
	}
	


	@Override
	public List<Manager> getManager() {
		String sql = "select * from managers;";
		List<Manager> managers = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int m_id = rs.getInt("m_id");
				String m_name = rs.getString("m_name");
				String m_username = rs.getString("m_username");
				String m_password = rs.getString("m_password");
				
				
				Manager newCus = new Manager(m_id, m_name, m_username, m_password);
				managers.add(newCus);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managers;
	}

	@Override
	public void addManager(Manager manager) throws SQLException, IOException { //throws SQLException, IOException
		int genId = -1;
		String sql = "insert into managers (m_name, m_username, m_password) "
				+ "values (?, ?, ?) returning m_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, manager.getName());
			ps.setString(2, manager.getUsername());
			ps.setString(3, manager.getPassword());
			
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("m_id");
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
//		return genId;
	}
	
	public Manager getUser(String username) throws SQLException, IOException {
		Manager m = null;
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from managers where m_username = '" + username + "';" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while ( rs.next() ) {
			
			
			m = new Manager(rs.getString("m_name"), rs.getString("m_username"), rs.getString("m_password"));
			m.setId(rs.getInt("m_id"));
			return m;
		}

		return null;
	}

	@Override
	public boolean updateManager(Manager manager) {
		String sql = "update managers set m_name = ?, m_username = ?, m_password = ? "
				+ "where m_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, manager.getName());
			ps.setString(2, manager.getUsername());
			ps.setString(3, manager.getPassword());
	
			ps.setInt(4, manager.getId());

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
	public int deleteManager(int id) {
		String sql = "delete from managers where m_id = ?;";
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
