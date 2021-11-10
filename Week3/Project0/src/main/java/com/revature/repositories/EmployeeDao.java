package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {
	
	Employee getEmployeeById(int id);
	List<Employee> getEmployees();
	boolean updateEmployee(Employee employee);
	int deleteEmployee(int id);
	void addEmployee(Employee e) throws SQLException, IOException;
	Employee getUser(String username) throws SQLException, IOException;

}
