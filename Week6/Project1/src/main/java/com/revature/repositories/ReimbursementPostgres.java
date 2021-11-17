package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementPostgres implements ReimbursementDao {

	public boolean submitReimbRequest(Reimbursement r) {
		
		return false;
	}

	public Reimbursement viewPendingReimb(User u) {
	
		return null;
	}

	public Reimbursement viewResolvedReimb(User u) {
		
		return null;
	}

	public Reimbursement viewPendingRequests() {
		
		return null;
	}

	public boolean updateRequest(Reimbursement r) {
		
		return false;
	}

	public Reimbursement viewResolvedRequests() {
		
		return null;
	}

	public Reimbursement viewRequest(User u) {
		
		return null;
	}

}
