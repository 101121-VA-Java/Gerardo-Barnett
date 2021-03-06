package com.revature.models;

import java.util.Objects;

public class Videogame {
	private int id;
	private String name;
	private String publisher;
	private String genre;
	private double price;
	private int quantity;
	
	public Videogame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Videogame(int id, String name, String publisher, String genre, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.genre = genre;
		this.price = price;
		this.quantity = quantity;
	}
	
	

	public Videogame(String name, String publisher, String genre, double price, int quantity) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.genre = genre;
		this.price = price;
		this.quantity = quantity;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, id, name, price, publisher, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videogame other = (Videogame) obj;
		return Objects.equals(genre, other.genre) && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(publisher, other.publisher) && quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Videogame [id=" + id + ", name=" + name + ", publisher=" + publisher + ", genre=" + genre + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

	

}
