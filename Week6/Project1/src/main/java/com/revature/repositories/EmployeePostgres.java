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
		String sql = "insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
	try(Connection con = ConnectionUtil.getConnectionFromFile()){
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setDouble(1, re.getReimAmount());
		ps.setTimestamp(2, re.getSubmit());
		ps.setTimestamp(3, re.getResolve());
		ps.setString(4, re.getDescription());
		ps.setString(5, re.getAuthor().getUsername());
		ps.setInt(6, re.getResolver().getManager());
		ps.setInt(7, re.getStatus().getStatusId());
		ps.setInt(8, re.getType().getTypeId());
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
		String sql = "select * from ers_reimbursement where reimb_author = ? and reimb_status_id = 1;";
		ArrayList<Reimbursement> pendingList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();
			
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
	public ArrayList<Reimbursement> viewMyResolved(User u) {
		String sql = "select * from ers_reimbursement where reimb_author = ? and reimb_status_id = 2;";
		ArrayList<Reimbursement> resolvedList = new ArrayList<Reimbursement>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();

			while ( rs.next() ) {	
				Reimbursement re = new Reimbursement(rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submit"), u, 
						rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id"));
				resolvedList.add(re);
			}
			
			}
			catch (SQLException | IOException e) {			
				e.printStackTrace();			
			}
		
		return resolvedList;
		
	}

}
