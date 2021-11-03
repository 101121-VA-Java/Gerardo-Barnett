package com.revature.models;

import java.util.Objects;

public class Customer {
	private int id;
	private String name;
	private String username;
	private String password;
	private int creditcard;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String username, String password, int creditcard) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.creditcard = creditcard;
	}

	public Customer(String name, String username, String password, int creditcard) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.creditcard = creditcard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(int creditcard) {
		this.creditcard = creditcard;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creditcard, id, name, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return creditcard == other.creditcard && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", creditcard=" + creditcard + "]";
	}
	
	
	
	
	
	
	
}

