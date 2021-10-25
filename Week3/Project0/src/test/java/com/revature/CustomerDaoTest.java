package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Customer;
import com.revature.repositories.CustomerArray;
import com.revature.repositories.CustomerDao;

public class CustomerDaoTest {
	
private static CustomerDao cd;
	
	@BeforeEach
	public void setup() {
		Customer[] customers = {new Customer(0, "Gerardo", "ger", "Opeth")}; 

		cd = new CustomerArray(customers);
	}
	
	@Test
	public void getAllCustomers(){
		Customer[] expected = {new Customer(0, "Gerardo", "ger", "Opeth")};
		Customer[] actual = cd.getAllCustomers();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void addCustomerValid() {
		Customer[] expected = {new Customer(0, "Gerardo", "ger", "Opeth"), 
								new Customer(1, "Nancy", "nan", "1D") };
		
		// Adding an employee
		cd.addCustomer(new Customer(1, "Nancy", "nan", "1D"));
		
		assertArrayEquals(expected, cd.getAllCustomers());
	}
	
	

}
