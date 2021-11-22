package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

import io.javalin.http.Context;

public interface EmployeeDao {
	
	boolean submitMyRequest (Reimbursement re);
	ArrayList<Reimbursement> viewMyPending(User u);
	ArrayList<Reimbursement> viewMyResolved(User u);

}
