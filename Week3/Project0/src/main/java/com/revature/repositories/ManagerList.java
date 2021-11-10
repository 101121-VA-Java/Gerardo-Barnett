package com.revature.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Manager;

public class ManagerList implements ManagerDao{

	@Override
	public Manager getManagerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> getManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addManager(Manager manager) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateManager(Manager manager) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteManager(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Manager getUser(String username) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
