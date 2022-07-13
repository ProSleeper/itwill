package com.guest;

public class GuestCustomDTO extends GuestDTO{
	private String 	pw;
	private String 	name;
	

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		String str;
		
		str = String.format("%8s %8s %8s ",
				id, pw, name);
		
		return str;
	}
}
