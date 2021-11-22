package com.revature.controllers;

import io.javalin.http.Context;

public class ManagerController {
	
	public static void viewAllPending(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewAllResolved(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewAllEmployees(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewReByUserId(Context ctx) {    
    	ctx.result("list");
    }
    public static void updateReStatus(Context ctx) {    
    	ctx.result("list");
    }

}
