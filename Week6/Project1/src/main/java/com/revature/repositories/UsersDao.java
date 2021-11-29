package com.revature.repositories;

import com.revature.models.User;

public interface UsersDao {
	
	User getUserByUsername(String username);
	User getUserById(int userId);
	User viewMyInfo(String username);
	boolean updateMyInfo(User u);

}
