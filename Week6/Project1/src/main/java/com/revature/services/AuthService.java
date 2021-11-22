package com.revature.services;

import java.util.Arrays;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.DaoFactory;
import com.revature.repositories.UsersDao;

public class AuthService {
	
private UsersDao ud;
	
	public AuthService() {
		ud = DaoFactory.getDaoFactory().getUsersDao();
	}
	
	
	public String loginSystem(String username, String password) {
		
		String token = null;
		
		User principal = ud.getUserByUsername(username);
		
		if(principal != null && principal.getPassword().equals(password)) {
			token = principal.getId() + ":" + principal.getRole();
		}
		
		return token;
	}
	
	/* I want to implement these info clips!! 
	 * @param String token, Role
	 * @return true if user is granted permission to certain pages
	 */
	public boolean authPermission(String token, Role... allowedRoles) {
		
		if(token == null) {
			return false;
		}
		
		String[] info = token.split(":");
		int token_id = Integer.parseInt(info[0]);
		Role token_role = Role.valueOf(info[1]);
		User principal = ud.getUserById(token_id);
		
		if(principal != null && token_role.equals(principal.getRole())
				&& Arrays.asList(allowedRoles).contains(token_role)) {
			return true;
		}
		return false;
		
	}


}
