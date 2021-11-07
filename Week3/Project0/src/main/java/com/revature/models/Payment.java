package com.revature.models;

public class Payment {
	
	private int p_id;
	private int o_id;
	private int c_id;
	private int v_id;
	private boolean paymentMade;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int p_id, int o_id, int c_id, int v_id, boolean paymentMade) {
		super();
		this.p_id = p_id;
		this.o_id = o_id;
		this.c_id = c_id;
		this.v_id = v_id;
		this.paymentMade = paymentMade;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
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
	public boolean isPaymentMade() {
		return paymentMade;
	}
	public void setPaymentMade(boolean paymentMade) {
		this.paymentMade = paymentMade;
	}
	@Override
	public String toString() {
		return "Payment [p_id=" + p_id + ", o_id=" + o_id + ", c_id=" + c_id + ", v_id=" + v_id + ", paymentMade="
				+ paymentMade + "]";
	}
	
	

}
