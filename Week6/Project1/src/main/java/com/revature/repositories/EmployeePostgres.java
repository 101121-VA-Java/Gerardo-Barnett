package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao{

	@Override
	public boolean submitMyRequest(Reimbursement re) {
		String sql = "insert into ers_reimbursement(reCreator, reAmount, reDescription, reStatus, reType)"
				+ "values (?, ?, ?, ?, ?)";
	try(Connection con = ConnectionUtil.getConnectionFromFile()){
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, re.getAuthor().getUsername());
		ps.setDouble(2, re.getReimAmount());
		ps.setString(3, re.getDescription());
		ps.setInt(4, re.getStatus().getStatusId());
		ps.setInt(5, re.getType().getTypeId());
		return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
		
	}

	@Override
	public ArrayList<Reimbursement> viewMyPending(User u) {
		String sql = "select * from ers_reimbursement where reimb_author = ? and reimb_status_id = 0;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {		
				Reimbursement re = new Reimbursement(rs.getInt("reimId"), rs.getString("author"), 
						rs.getDouble("reimAmount"), rs.getString("description"), 
						rs.getString("status"), rs.getString("type"));
				pendingList.add(re);
			}
			
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
			return pendingList;
		return null;
	}

	@Override
	public ArrayList<Reimbursement> viewMyResolved(User u) {
		String sql = "select * from ers_reimbursement where reimb_author = ? and reimb_status_id = 1;";
		ArrayList<Reimbursement> resolvedList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();

			while ( rs.next() ) {	
				Reimbursement re = new Reimbursement(rs.getInt("reimId"), rs.getString("author"), 
						rs.getDouble("reimAmount"), rs.getString("description"), 
						rs.getString("status"), rs.getString("type"));
				resolvedList.add(re);
			}
			
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
		
		return resolvedList;
		
	}

}
