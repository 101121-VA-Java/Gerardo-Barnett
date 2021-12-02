package com.revature.repositories;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements UsersDao{

	@Override
	public User getUserByUsername(String username) {
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from ers_users where ers_username = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new User(
						rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_email"),
						rs.getInt("user_role_id"),
						rs.getInt("ers_manager_id")
						);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
		
	}

	@Override
	public User getUserById(int userId) {
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from ers_users where ers_users_id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new User(
						rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_email"),
						rs.getInt("user_role_id"),
						rs.getInt("ers_manager_id")
						);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
	}

	@Override
	public User viewMyInfo(String username) {
		User u = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "select * from ers_users where ers_username = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				u = new User(
						rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_email"),
						rs.getInt("user_role_id"),
						rs.getInt("ers_manager_id")
						);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean updateMyInfo(User u) {
		// TODO Auto-generated method stub
		String sql = "update ers_users set ers_username = ?, ers_password = ?, "
				+ "ers_first_name = ?, ers_last_name = ?, ers_email = ? where ers_users_id = ?;" ;
		
		int rowsChanged = -1;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getId());

			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	

}
