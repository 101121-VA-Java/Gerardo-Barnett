package com.revature.models;

public class Status {
	private int statusId;
	private String status;
	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + "]";
	}
	
	
	
	

}
