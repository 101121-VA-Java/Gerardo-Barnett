package com.revature.models;

public class Type {
	private int typeId;
	private String type;
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	
	public Type(int typeId) {
		super();
		this.typeId = typeId;
		
		switch (typeId) {
		case 1:
			type = "LODGING";
			break;
		case 2:
			type = "TRAVEL";
			break;
		case 3:
			type = "FOOD";
			break;
		case 4:
			type = "OTHER";
			break;
		default:
			type = "unknown";
			// log here
			break;		
		}
				
	}


	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", type=" + type + "]";
	}
	
	

}
