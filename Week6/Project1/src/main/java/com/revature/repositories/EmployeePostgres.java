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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Reimbursement> viewMyPending(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reimbursement> viewMyResolved(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
