package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDao {
	
	    //employees reimbursement
		boolean submitReimbRequest(Reimbursement r);	
		Reimbursement viewPendingReimb(User u);	
		Reimbursement viewResolvedReimb(User u);
		
		//managers reimbursement
		Reimbursement viewPendingRequests();
		boolean updateRequest(Reimbursement r);
		Reimbursement viewResolvedRequests();
		Reimbursement viewRequest(User u);
	

}
