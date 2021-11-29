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
    
    public static void updateInfo(Context ctx) {    
    	ctx.result("list");
    }
    
    public static void viewInfo(Context ctx) {    
//    	if (UserAuthController.checkToken(ctx) == true) { 
//    	EmployeeService es = new EmployeeService();
//    	User u = es.viewAccountInfo(splitToken(ctx)[0]);
//    	GsonBuilder gsonBuilder = new GsonBuilder();
//		Gson gson = gsonBuilder.create();
//		String JSONObject = gson.toJson(u);
//		ctx.result(JSONObject);
//    	}
//    	else {
//    		ctx.result("false");
//    	}
    	
    }
    

}
