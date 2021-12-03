package com.revature.repositories;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserPostgres implements UserDao{

	private static Logger log = LogManager.getRootLogger();
	
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id;";

			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				User u = new User(rs.getInt("ers_users_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_email"), rs.getInt("user_role_id"), rs.getInt("ers_manager_id"));

				users.add(u);
			}
		} catch (SQLException | IOException u) {
			log.error("Connection failed!");
			u.printStackTrace();
		}

		return users;
	}

	@Override
	public User getEmployeeById(int id) {
		User user = null;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id where ers_users_id =?;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("ers_users_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_email"), rs.getInt("user_role_id"), rs.getInt("ers_manager_id"));
			}
		} catch (SQLException | IOException e) {
			log.error("Connection failed!");
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getEmployeeByUsername(String username) {
		User user = null;

		try (Connection c = ConnectionUtil.getConnectionFromFile()) {
			String sql = "select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id where ers_username=?;";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_email"),
						rs.getInt("user_role_id"),
						rs.getInt("ers_manager_id"));
			}
		} catch (SQLException | IOException e) {
			log.error("Connection failed!");
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User addEmployee(User u) {
	User newUser = null;
			
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, ers_manager_id) values (?,?,?,?,?);"; //Check SQL statement before finishing this method.
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			
			

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				newUser = u;
				newUser.setId(rs.getInt("ers_users_id"));
				newUser.setRole(2);
				newUser.setManager(1);
			}
		} catch (SQLException | IOException e1) {
			log.error("Connection failed!");
			e1.printStackTrace();
		}
		
		return newUser;
	}

	@Override
	public boolean updateEmployee(User e) {
		
	boolean result = false;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "update ers_users set ers_username = ?, ers_password = ?, user_first_name = ?, user_last_name = ?, user_email = ?, user_role_id = ?, ers_manager_id WHERE ers_users_id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getFirstName());
            ps.setString(5, e.getLastName());
            ps.setInt(6, e.getRole());
			ps.setInt(7, e.getId());
			 ps.executeUpdate();
			 result = true;
			
		} catch (SQLException | IOException e1) {
			log.error("Connection failed!");
			e1.printStackTrace();
		} 
		return result;
	}



}
