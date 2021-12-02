package com.revature.services;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ManagerDao;
import com.revature.repositories.ManagerPostgres;
import com.revature.repositories.UserPostgres;
import com.revature.repositories.UsersDao;

import io.javalin.http.Context;

public class ManagerService {
	
//	ManagerDao mp = new ManagerPostgres();
//	UsersDao ud = new UserPostgres();
//	
//	public List<Reimbursement> getAllPendingRequests(){
//		List<Reimbursement> allReimbursements = mp.viewAllPending();
//		List<Reimbursement> allPendingReimbursements = new ArrayList<>();
//		for(Reimbursement r: allReimbursements) {
//			if(r.getStatus().getStatusId() == Status.PENDING) {
//				allPendingReimbursements.add(r);
//			}
//		}
//		return allPendingReimbursements;
//	}
//	
//	public List<Reimbursement> getAllResolvedRequests(){
//		List<Reimbursement> allReimbursements = mp.viewAllResolved();
//		List<Reimbursement> allResolvedReimbursements = new ArrayList<>();
//		for(Reimbursement r: allReimbursements) {
//			if(r.getStatus().getStatusId() == Status.APPROVED || r.getStatus().getStatusId() == Status.DENIED ) {
//				allResolvedReimbursements.add(r);
//			}
//		}
//		return allResolvedReimbursements;
//	}
//	
	
	
	
	
//	public boolean approveByReimbID(int ReimbID, int resolverID) {
//		Reimbursement r = mp.getId(ReimbID);
//		r.setStatus(new Status(2));
//		
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		r.setResolve(timestamp);
//		
//		r.setResolver(resolverID);
//		
//		return mp.update(r);
//	}
//	
//	public boolean denyByReimbID(int ReimbID, int resolverID) {
//		Reimbursement r = mp.getByID(ReimbID);
//		r.setStatus(new Status(3));
//		
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		r.setResolve(timestamp);
//		
//		r.setResolver(resolverID);
//		
//		return mp.update(r);
//	}
//	
//	public List<User> getAllByAuthorID(int id){
//		List<User> reimbursements = ud.getUserById(id);
//		
//		return reimbursements;
//	}

}
