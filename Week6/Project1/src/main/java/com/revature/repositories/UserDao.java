package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserDao{
	
	List<User> getUsers();

	User getEmployeeById(int id);

	User getEmployeeByUsername(String username);

	User addEmployee(User e);

	boolean updateEmployee(User e);
	
	
		

}
