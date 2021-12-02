package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.models.User;
import com.revature.repositories.DaoFactory;
import com.revature.repositories.UserDao;

public class UserService {
	
	private UserDao ud;

	// Retrieving an instance of EmployeeDao
	public UserService() {
		ud = DaoFactory.getDAOFactory().getUserDao();
	}

	
	public List<User> getEmployees(){
		
		List<User> employees = ud.getUsers().stream()
				.map(e -> {
					e.setPassword(null); 
					return e;})
				.collect(Collectors.toList());
		
		return employees;
	}
	
	
	

	public User getEmployeeById(int id){
		User u = ud.getEmployeeById(id);
		if (u != null) {
			u.setPassword(null);
		}
		
		return u;
	}
	
	
	public User getEmployeeByUsername(String username){
		User u = ud.getEmployeeByUsername(username);
		if (u != null) {
			u.setPassword(null);
		}
		
		return u;
	}
	
	public User addEmployee(User u) {
		// assigning a default manager/role
		
		u.setRole(2);

		return ud.addEmployee(u);
	}
	
	
	public boolean updateEmployeeInfo(User u) {
		
		User e_update = ud.getEmployeeById(u.getId());
		
		// if name isn't null or the same update the name to a new value
		if(u.getFirstName() != null && !u.getFirstName().equals(e_update.getFirstName())) {
			e_update.setFirstName(u.getFirstName());
		}
		if(u.getLastName() != null && !u.getLastName().equals(e_update.getLastName())) {
			e_update.setLastName(u.getLastName());
		}
		
		// if username isn't null or the same update the name to a new value
		if(u.getUsername() != null && !u.getUsername().equals(e_update.getUsername())) {
			e_update.setUsername(u.getUsername());
		}
		
		// if password isn't null or the same update the name to a new value
		if(u.getPassword() != null && !u.getPassword().equals(e_update.getPassword())) {
			e_update.setPassword(u.getPassword());
		}
		if(u.getEmail() != null && !u.getEmail().equals(e_update.getEmail())) {
			e_update.setEmail(u.getEmail());
		}
		return ud.updateEmployee(e_update);	
	}
	
}
