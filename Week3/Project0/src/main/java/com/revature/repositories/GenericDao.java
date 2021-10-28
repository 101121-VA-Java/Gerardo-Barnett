package com.revature.repositories;

import com.revature.models.Customer;

public interface GenericDao <C>{

	C getAllCustomers(); // returns an array of all of the employees available
	C getCustomerById(int id);
	int addCustomer(C c); // returns assigned id
	boolean editCustomer(C c);  //returns boolean depending on operation success 
	boolean deleteCustomer(int id);  //returns boolean depending on operation success 
}
