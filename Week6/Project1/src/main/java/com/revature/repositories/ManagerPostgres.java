package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ManagerPostgres implements ManagerDao{

	@Override
	public ArrayList<Reimbursement> viewAllPending() {
		User u = null;
		String sql = "select * from ers_reimbursement where reimb_status_id = 1;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
			
			try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while ( rs.next() ) {		
					Reimbursement re = new Reimbursement(rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submitted"), u, 
							rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
					pendingList.add(re);
				}
				
				}
				catch (SQLException | IOException e) {			
					e.printStackTrace();			
				}
				return pendingList;

		
	}

	@Override
	public boolean updateRequest(Reimbursement re) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Reimbursement> viewAllResolved() {
		User u = null;
		String sql = "select * from ers_reimbursement where reimb_status_id = 2;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
			
			try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				
				while ( rs.next() ) {		
					Reimbursement re = new Reimbursement(rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submitted"), u, 
							rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
					pendingList.add(re);
				}
				
				}
				catch (SQLException | IOException e) {			
					e.printStackTrace();			
				}
				return pendingList;
	}

	@Override
	public Reimbursement viewSpecificRequest() {
		User u = null;
		Reimbursement re = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ers_reimbursement where reimb_author = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {		
				re = new Reimbursement(rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submitted"), u, 
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return re;
	}

	@Override
	public List<User> viewAllEmployees() throws IOException, SQLException {
		String sql = "select * from ers_users;";
		List<User> u = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				u.add(null);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public User add(User u) {
		String sql = "insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, ers_manager_id) "
				+ "values (?, ?, ?, ?, ?, ?, ?);";
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getRole());
			ps.setInt(7, u.getManager());
		
			

			ps.execute();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public boolean update(Reimbursement re) {
		String sql = "update ers_reimbursement set reimb_amount = ?, reimb_submitted = ?, reimb_resolved = ?, reimb_description = ?, reimb_author = ?, reimb_resolver = ?, reimb_status_id = ?, reimb_type_id = ?"
				+ "where reimb_id = ?;" ;
		
		int rowsChanged = -1;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, re.getReimAmount());
			ps.setTimestamp(2, re.getSubmit());
			ps.setTimestamp(3, re.getResolve());
			ps.setString(4, re.getDescription());
			ps.setString(5, re.getAuthor().getUsername());
			ps.setInt(6, re.getResolver().getManager());
			ps.setInt(7, re.getStatus().getStatusId());
			ps.setInt(8, re.getType().getTypeId());

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
	
	public Reimbursement remove(Reimbursement re) {
		String sql = "delete from ers_reimbursement where reimb_id = ?;";
		int rowsChanged = -1;
		int id = re.getReimId();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		if (rowsChanged > 0) {
			return null;
		} else {
			return re;
		}
	}


}
