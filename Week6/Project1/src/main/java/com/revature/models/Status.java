package com.revature.models;

public class Status {
	public static int PENDING = 1;
	public static int APPROVED = 2;
	public static int DENIED = 3;
	
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

	public Status(int statusId) {
		super();
		this.statusId = statusId;
		if (statusId == 1) {
		status = "pending";
		}
		else if (statusId == 2)  {
		status = "approved";
		}
		else if (statusId == 3) {
		status = "denied";
		}
		else {
			//log here
		}
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
