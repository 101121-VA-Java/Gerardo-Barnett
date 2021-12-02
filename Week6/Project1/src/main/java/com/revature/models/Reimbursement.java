package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	private int reimId;
	private double reimAmount;
	private Timestamp submit;
	private Timestamp resolve;
	private String description;
//	private blob picture
	private int author;
	private int resolver;
	private int status;
	private int type;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimId, double reimAmount, Timestamp submit, Timestamp resolve, String description,
			int author, int resolver, int status, int type) {
		super();
		this.reimId = reimId;
		this.reimAmount = reimAmount;
		this.submit = submit;
		this.resolve = resolve;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", reimAmount=" + reimAmount + ", submit=" + submit + ", resolve="
				+ resolve + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", status=" + status + ", type=" + type + "]";
	}

	
	
	
	

}
