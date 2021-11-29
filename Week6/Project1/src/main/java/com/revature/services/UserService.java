package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserPostgres;
import com.revature.repositories.UsersDao;

public class UserService {
	
	UserPostgres up = new UserPostgres();
	private UsersDao ud;
	
	User getUserByUsername(String username) {
		User u = null;
		u = ud.getUserByUsername(username);
		return u;
	}
	User getUserById(int userId) {
		User u = null;
		u = ud.getUserById(userId);
		return u;
	}
	User viewMyInfo(String username) {
		return up.getUserByUsername(username);
	}
	public boolean updateMyInfo(User u) {
		if(ud.updateMyInfo(u)) {
			return true;
		}
		return false;
	}

}
