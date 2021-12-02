package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.UserPostgres;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class EmployeeController {
	public static UserService us = new UserService();
	public static UserPostgres up = new UserPostgres();
	
	public static void getUserById(Context ctx) {    
		
		String token = ctx.header("Authorization");
		int id = Integer.parseInt(ctx.pathParam("id"));

		User employee = up.getUserById(id);

		if (employee != null) {
			ctx.json(employee);
			ctx.status(HttpCode.OK);
		} else {
//			ctx.status(404);
			ctx.status(HttpCode.NOT_FOUND);
		}
		
    	ctx.result("list");
    }
    
    public static void submitMyRequest(Context ctx) {    
//    	String amountString = ctx.formParam("amount");
//		String reimbursementTypeString = ctx.formParam("reimbursementType");
//		
//		
//		double amount = Double.parseDouble(amountString);
//		int reimbursementType = Integer.parseInt(reimbursementTypeString);
//		String description = ctx.formParam("description");
//		
//		String token = ctx.header("Authorization");
//		System.out.println(token);
//		String[] info = token.split(":");
//		int token_id = Integer.parseInt(info[0]);
//		
//		Reimbursement r = rs.createNewReimbursement(token_id, amount, reimbursementType, description);
//		
//		if (r != null) {
//			ctx.status(HttpCode.OK);
//		} else {
//			ctx.status(HttpCode.BAD_REQUEST);
//		}
    	
    	ctx.result("list");
    }
  
    public static void viewMyResolved(Context ctx) {    
//    	String token = ctx.header("Authorization");
//		String[] info = token.split(":");
//		int token_id = Integer.parseInt(info[0]);
//		List<Reimbursement> resolved = rs.getResolvedByAuthorID(token_id);
//		ctx.json(resolved);
//		ctx.status(HttpCode.OK);
//    	
//    	ctx.result("list");
    }
    public static void viewMyPending(Context ctx) {    
//    	String token = ctx.header("Authorization");
//		String[] info = token.split(":");
//		int token_id = Integer.parseInt(info[0]);
//		List<Reimbursement> pending = rs.getPendingByAuthorID(token_id);
//		ctx.json(pending);
//		ctx.status(HttpCode.OK);
    	
    	ctx.result("list");
    }
    
    public static void updateInfo(Context ctx) {    
//    	String token = ctx.header("Authorization");
//		int id = Integer.parseInt(ctx.pathParam("id"));
//		
//		User u = ctx.bodyAsClass(User.class);
//		User uCompare = us.getUserById(id);
//		
//		if(u.getUsername() != null) {
//			uCompare.setUsername(u.getUsername());
//		}
//		
//		if(u.getFirstName() != null) {
//			uCompare.setFirstName(u.getFirstName());
//		}
//		
//		if(u.getLastName() != null) {
//			uCompare.setLastName(u.getLastName());
//		}
//		
//		if(u.getEmail() != null) {
//			uCompare.setEmail(u.getEmail());
//		}
//		
//		if(us.updateUserByID(uCompare)) {
//			ctx.status(HttpCode.OK);
//		} else {
//			ctx.status(400);
//		}
    	
    	ctx.result("list");
    }
    
    public static void viewInfo(Context ctx) {    

    	
    }
    

}
