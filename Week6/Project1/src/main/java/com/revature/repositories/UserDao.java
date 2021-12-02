package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDao extends GenericDao<User>{
	
    boolean loginUser (User u);
	
	User viewUserInfo(User u);	
	User updateUserInfo(User u);
	
	User viewAllEmployees();	
	
	
		

}
