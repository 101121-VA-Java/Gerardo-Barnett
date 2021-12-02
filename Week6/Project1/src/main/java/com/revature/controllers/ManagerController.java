package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.ManagerPostgres;
import com.revature.services.ManagerService;
import com.revature.services.UserService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ManagerController {
//	public static UserService us = new UserService();
//	public static ManagerService ms = new ManagerService();
//	public static ManagerPostgres mp = new ManagerPostgres();
//	
//	public static void viewAllPending(Context ctx) {    
//		String token = ctx.header("Authorization");
//		if(token == null) {
//			ctx.status(HttpCode.BAD_REQUEST);
//		}
//		List<Reimbursement> pending = ms.getAllPendingRequests();
//		ctx.json(pending);
//		ctx.status(HttpCode.OK);
//		
//		ctx.result("list");
//    }
//    public static void viewAllResolved(Context ctx) {    
//    	String token = ctx.header("Authorization");
//		if(token == null) {
//			ctx.status(HttpCode.BAD_REQUEST);
//		}
//		List<Reimbursement> resolved = ms.getAllResolvedRequests();
//		ctx.json(resolved);
//		ctx.status(HttpCode.OK);
//    	ctx.result("list");
//    }
//    public static void viewAllEmployees(Context ctx) throws IOException, SQLException {    
//    	List<User> allUsers = mp.viewAllEmployees();
//		if (allUsers != null) {
//			ctx.json(allUsers);
//			ctx.status(HttpCode.OK);
//		} else {
//			ctx.status(HttpCode.NOT_FOUND);
//		}
//		ctx.result("list");
//    }
//    public static void viewReByUserId(Context ctx) {    
//    	ctx.result("list");
//    }
//    public static void updateReStatus(Context ctx) {    
//    	ctx.result("list");
//    }

}
