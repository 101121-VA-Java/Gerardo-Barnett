package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
					Reimbursement re = new Reimbursement(rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submit"), u, 
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
					Reimbursement re = new Reimbursement(rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submit"), u, 
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
				re = new Reimbursement(rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submit"), u, 
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
	public ArrayList<User> viewAllEmployees() throws IOException, SQLException {
		User u = null;
		Connection con = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from ers_users u join ers_user_roles r on u.ers_username = r.uname "
				+ "where u.ers_username = ? ;" ;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getUsername());
		ResultSet rs = ps.executeQuery();
		
		while ( rs.next() ) {
			
			
		}
		return null;
	}

}
