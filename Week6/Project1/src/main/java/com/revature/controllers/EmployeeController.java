package com.revature.controllers;

import io.javalin.http.Context;

public class EmployeeController {
	
	public static void getUserById(Context ctx) {    
    	ctx.result("list");
    }
    
    public static void submitMyRequest(Context ctx) {    
    	ctx.result("list");
    }
  
    public static void viewMyResolved(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewMyPending(Context ctx) {    
    	ctx.result("list");
    }

}
