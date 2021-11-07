package com.revature.models;

public class Offer {
	
	private int o_id;
	private int c_id ;		
	private int v_id;	 
	private double offer;  
	private boolean o_accepted; 
	private boolean o_payment;
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(int o_id, int c_id, int v_id, double offer, boolean o_accepted, boolean o_payment) {
		super();
		this.o_id = o_id;
		this.c_id = c_id;
		this.v_id = v_id;
		this.offer = offer;
		this.o_accepted = o_accepted;
		this.o_payment = o_payment;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public double getOffer() {
		return offer;
	}

	public void setOffer(double offer) {
		this.offer = offer;
	}

	public boolean isO_accepted() {
		return o_accepted;
	}

	public void setO_accepted(boolean o_accepted) {
		this.o_accepted = o_accepted;
	}

	public boolean isO_payment() {
		return o_payment;
	}

	public void setO_payment(boolean o_payment) {
		this.o_payment = o_payment;
	}

	@Override
	public String toString() {
		return "Offer [o_id=" + o_id + ", c_id=" + c_id + ", v_id=" + v_id + ", offer=" + offer + ", o_accepted="
				+ o_accepted + ", o_payment=" + o_payment + "]";
	}
	
	
	
	

}
