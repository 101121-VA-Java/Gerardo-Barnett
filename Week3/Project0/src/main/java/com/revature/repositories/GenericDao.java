package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;

public interface GenericDao<C>{

	
	C getCustomerById(int id);
	List<C> getAllCustomers();
	C addCustomer(C c); // returns assigned id
	boolean editCustomer(C c);  //returns boolean depending on operation success 
	boolean deleteCustomer(int id);  //returns boolean depending on operation success 
}
