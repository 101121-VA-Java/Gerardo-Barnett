package com.revature.services;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.DaoFactory;
import com.revature.repositories.UserDao;

public class AuthService {
	
private UserDao ud;
private static Logger log = LogManager.getRootLogger();
	
	public AuthService() {
		ud = DaoFactory.getDAOFactory().getUserDao();
	}
	
	
	public String loginSystem(String username, String password) {
		
		String token = null;
		
		User principal = ud.getEmployeeByUsername(username);
		System.out.println(principal);
		if(principal != null && principal.getPassword().equals(password)) {
			token = principal.getId() + ":" + principal.getRole();
		}
		log.trace("Login has been successful");
		System.out.println(token);
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
		User principal = ud.getEmployeeById(token_id);
		
		if(principal != null && token_role.equals(principal.getRole())
				&& Arrays.asList(allowedRoles).contains(token_role)) {
			return true;
		}
		return false;
		
	}
	
	public User getUserByUsername(String username) {
		return ud.getEmployeeByUsername(username) ;
	}


}
