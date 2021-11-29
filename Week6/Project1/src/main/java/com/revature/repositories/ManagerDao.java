package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerDao {
	
	ArrayList<Reimbursement> viewAllPending();
	boolean updateRequest(Reimbursement re);
	ArrayList<Reimbursement> viewAllResolved();
	Reimbursement viewSpecificRequest();
	ArrayList<User> viewAllEmployees() throws IOException, SQLException;

}
