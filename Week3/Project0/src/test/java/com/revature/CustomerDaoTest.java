package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;
import com.revature.repositories.CustomerList;
import com.revature.repositories.CustomerPostgres;

public class CustomerDaoTest {
	
    
    private CustomerDao cd = new CustomerList();

    @BeforeEach
    public void setUp() {
    	cd = new CustomerPostgres();
    }

//    @Test
//    public void getAllCustomers() {
//    	List<Customer> expected = new ArrayList<>();
//    	expected.add(new Customer(0, "Gerardo", "GerardoB", "Opeth", 12345678));
//
//    	assertEquals(expected, cd.getCustomers());
//    }
//
//    @Test
//    public void getCustomerByIdExist() {
//    	Customer expected = new Customer(0, "Gerardo", "GerardoB", "Opeth", 12345678);
//
//    	assertEquals(expected, cd.getCustomerById(0));
//    }
    
    @Test
	public void getByIdValid() {
		Customer expected = new Customer(1, "Gerardo", "GerardoB", "Opeth", 12345678);
		Customer actual = cd.getCustomerById(1);
		assertEquals(expected, actual);
	}
    
//
//    @Test
//    public void getCustomerByIdDoesNotExist() {
//    	assertEquals(null, cd.getById(10));
//    }
//
//    @Test
//    public void addCustomer() {
//    	List<Customer> expected = new ArrayList<>();
//    	expected.add(new Customer(0, "Gerardo", "GerardoB", "Opeth"));
//    	expected.add(new Customer(1, "Nancy", "NancyT", "1D"));
//
//    	cd.add(new Customer(0, "Nancy", "NancyT", "1D"));
//    	assertEquals(expected, cd.getAll());
//    }
//
//    @Test
//    public void editCustomerValid() {
//    	Customer expected = new Customer(0, "Gerardo", "GerardoB", "Opeth");
//    	Customer sus = new Customer(0, "Gerardo", "GerardoB", "Opeth");
//
//    	cd.edit(sus);
//
//    	assertEquals(expected, cd.getById(0));
//    }
//
//    @Test
//    public void editCustomerInvalidId() {
//    	;
//    	Customer sus = new Customer(10, "Gerardo", "GerardoB", "Opeth");
//
//    	assertFalse(cd.edit(sus));
//    }
//
//    @Test
//    public void editCustomerNoChange() {
//    	;
//    	Customer sus = new Customer(0, "Gerardo", "GerardoB", "Opeth");
//
//    	assertFalse(cd.edit(sus));
//    }
//	

}
