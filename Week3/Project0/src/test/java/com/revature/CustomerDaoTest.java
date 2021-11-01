package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.revature.models.Customer;
import com.revature.repositories.CustomerList;
import com.revature.repositories.CustomerDao;

public class CustomerDaoTest {
	
    
    private CustomerDao cd = new CustomerList();

    @BeforeEach
    public void setUp() {
    	cd = new CustomerList();
    }

    @Test
    public void getAllCustomers() {
    	List<Customer> expected = new ArrayList<>();
    	expected.add(new Customer(0, "Gerardo", "GerardoB", "Opeth"));

    	assertEquals(expected, cd.getAll());
    }

    @Test
    public void getCustomerByIdExist() {
    	Customer expected = new Customer(0, "Gerardo", "GerardoB", "Opeth");

    	assertEquals(expected, cd.getById(0));
    }

    @Test
    public void getCustomerByIdDoesNotExist() {
    	assertEquals(null, cd.getById(10));
    }

    @Test
    public void addCustomer() {
    	List<Customer> expected = new ArrayList<>();
    	expected.add(new Customer(0, "Gerardo", "GerardoB", "Opeth"));
    	expected.add(new Customer(1, "Nancy", "NancyT", "1D"));

    	cd.add(new Customer(0, "Nancy", "NancyT", "1D"));
    	assertEquals(expected, cd.getAll());
    }

    @Test
    public void editCustomerValid() {
    	Customer expected = new Customer(0, "Gerardo", "GerardoB", "Opeth");
    	Customer sus = new Customer(0, "Gerardo", "GerardoB", "Opeth");

    	cd.edit(sus);

    	assertEquals(expected, cd.getById(0));
    }

    @Test
    public void editCustomerInvalidId() {
    	;
    	Customer sus = new Customer(10, "Gerardo", "GerardoB", "Opeth");

    	assertFalse(cd.edit(sus));
    }

    @Test
    public void editCustomerNoChange() {
    	;
    	Customer sus = new Customer(0, "Gerardo", "GerardoB", "Opeth");

    	assertFalse(cd.edit(sus));
    }
	

}
