package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Manager;

public interface ManagerDao {
	
	Manager getManagerById(int id);
	List<Manager> getManager();
	void addManager(Manager manager) throws SQLException, IOException;
	boolean updateManager(Manager manager);
	int deleteManager(int id);
	Manager getUser(String username) throws SQLException, IOException;

}
