package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerDao {
	
	Reimbursement viewAllPending();
	boolean updateRequest(Reimbursement re);
	Reimbursement viewAllResolved();
	Reimbursement viewSpecificRequest();
	User viewAllEmployees() throws IOException, SQLException;

}
