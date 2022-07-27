package com.guest;

public abstract class GuestDTO {

	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public abstract String toString();
}
