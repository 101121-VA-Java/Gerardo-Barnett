package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	private int reimId;
	private double reimAmount;
	private Timestamp submit;
	private Timestamp resolve;
	private String descrip;
//	private blob picture
	private User author;
	private User resolver;
	private Status status;
	private Type type;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimId, double reimAmount, Timestamp submit, Timestamp resolve, String descrip,
			User author, User resolver, Status status, Type type) {
		super();
		this.reimId = reimId;
		this.reimAmount = reimAmount;
		this.submit = submit;
		this.resolve = resolve;
		this.descrip = descrip;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public double getReimAmount() {
		return reimAmount;
	}

	public void setReimAmount(double reimAmount) {
		this.reimAmount = reimAmount;
	}

	public Timestamp getSubmit() {
		return submit;
	}

	public void setSubmit(Timestamp submit) {
		this.submit = submit;
	}

	public Timestamp getResolve() {
		return resolve;
	}

	public void setResolve(Timestamp resolve) {
		this.resolve = resolve;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", reimAmount=" + reimAmount + ", submit=" + submit + ", resolve="
				+ resolve + ", descrip=" + descrip + ", author=" + author + ", resolver=" + resolver + ", status="
				+ status + ", type=" + type + "]";
	}
	
	

}
