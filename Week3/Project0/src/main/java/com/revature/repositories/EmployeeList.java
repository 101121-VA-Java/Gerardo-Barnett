package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;

public class EmployeeList implements EmployeeDao{

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addEmployee(Employee e) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getUser(String username) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
