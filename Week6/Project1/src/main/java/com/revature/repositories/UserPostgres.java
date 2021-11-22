package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("email"), 
						null
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
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("firstName"),
						rs.getString("lastName"),
						rs.getString("email"), 
						null
						);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return u;
		
	}

	@Override
	public User viewMyInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateMyInfo(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
