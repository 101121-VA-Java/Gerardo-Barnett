package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;

public interface GenericDao<C>{

	
	C getById(int id);
	List<C> getAll();
	int add(C c); // returns assigned id
	boolean edit(C c);  //returns boolean depending on operation success 
	boolean delete(int id);  //returns boolean depending on operation success 
}
