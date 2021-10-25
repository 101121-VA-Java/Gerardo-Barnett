package com.revature.repositories;

import com.revature.models.Employee;

public interface EmployeeDao {
/*
 *  -getAllEmployees
 *  -getEmployeeById
 *  -addEmployee
 *  -editEmployee
 *  -deleteEmployee
 * 
 */
	
	Employee[] getAllEmployees();
	Employee getEmployeeById(int id);
	int addEmployee(Employee e);
	boolean editEmployee(Employee e);
	boolean deleteEmployee(int id);
	
}
