package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerDao {
	
	ArrayList<Reimbursement> viewAllPending();
	boolean updateRequest(Reimbursement re);
	ArrayList<Reimbursement> viewAllResolved();
	Reimbursement viewSpecificRequest();
	List<User> viewAllEmployees() throws IOException, SQLException;
	User add(User u);
	public boolean update(Reimbursement re);
	public Reimbursement remove(Reimbursement re);
}
