package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerPostgres implements CustomerDao{ 
	
	@Override
	public Customer getCustomerById(int id) {
		String sql = "select * from customers where c_id = ? ";
		Customer cus = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); // 1 refers to the first '?'	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int c_id = rs.getInt("c_id");
				String c_name = rs.getString("c_name");
				String c_username = rs.getString("c_username");
				String c_password = rs.getString("c_password");
				int c_creditcard = rs.getInt("c_creditcard");
				
				
				cus = new Customer(c_id, c_name, c_username, c_password, c_creditcard);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return cus;
	}
	


	@Override
	public List<Customer> getCustomers() {
		String sql = "select * from customers;";
		List<Customer> customers = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int c_id = rs.getInt("c_id");
				String c_name = rs.getString("c_name");
				String c_username = rs.getString("c_username");
				String c_password = rs.getString("c_password");
				int c_creditcard = rs.getInt("c_creditcard");
				
				Customer newCus = new Customer(c_id, c_name, c_username, c_password, c_creditcard);
				customers.add(newCus);
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public int addCustomer(Customer customer) {
		int genId = -1;
		String sql = "insert into customers (c_name, c_username, c_password, c_creditcard) "
				+ "values (?, ?, ?, ?) returning c_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getPassword());
			ps.setInt(4, customer.getCreditcard());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("c_id");
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return genId;
	}
	
	public Customer getUser(String username) throws SQLException, IOException {
		Customer c = null;
		Connection conn = ConnectionUtil.getConnectionFromFile();
		String sql = "select * from customers where username = '" + username + "';" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while ( rs.next() ) {
			
			
			c = new Customer(rs.getString("c_name"), rs.getString("c_username"), rs.getString("c_password"), rs.getInt("c_creditcard"));
			c.setId(rs.getInt("c_id"));
			return c;
		}

		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		String sql = "update customers set c_name = ?, c_username = ?, c_password = ?, c_creditcard = ? "
				+ "where e_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getPassword());
			ps.setInt(4, customer.getCreditcard());
			ps.setInt(6, customer.getId());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int deleteCustomer(int id) {
		String sql = "delete from customers where c_id = ?;";
		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			// if 1 is returned, indicates that 1 record was successfully deleted from the
			// table
			rowsChanged = ps.executeUpdate();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsChanged;
	}

}
