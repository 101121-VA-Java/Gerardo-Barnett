package com.revature.drivers;

import com.revature.controllers.UserController;

public class Driver {

	public static void main(String[] args) {
//		FrontController fc = new FrontController();
//		fc.run();
		
		UserController uc = new UserController();
        uc.userMenu();
	}

}
