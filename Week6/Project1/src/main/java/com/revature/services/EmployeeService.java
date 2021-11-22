package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeePostgres;

public class EmployeeService {
	
private EmployeeDao ed;
	
	EmployeeService(){
		super();
		ed = new EmployeePostgres();
	}
	
	
	public boolean submitMyRequest(Reimbursement re) {
		if(ed.submitMyRequest(re)) {
			return true;
		}
		return false;
	}
	
	public void viewMyPending(User u) {
		ArrayList<Reimbursement> reList = ed.viewMyPending(u);
	}
	
	public void viewMyResolved(User u) {
		ArrayList<Reimbursement> relist = ed.viewMyResolved(u);
	}

}
