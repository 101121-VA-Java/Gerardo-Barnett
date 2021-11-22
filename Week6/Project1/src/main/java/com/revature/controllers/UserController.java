package com.revature.controllers;

import io.javalin.http.Context;

public class UserController {
	
	public static void updateMyInfo(Context ctx) {    
    	ctx.result("list");
    }
    public static void viewMyInfo(Context ctx) {    
    	ctx.result("list");
    }

}
