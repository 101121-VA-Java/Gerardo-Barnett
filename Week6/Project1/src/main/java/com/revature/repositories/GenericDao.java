package com.revature.repositories;

import java.util.List;

public interface GenericDao<T> {

	
	List<T> getAll();
}
