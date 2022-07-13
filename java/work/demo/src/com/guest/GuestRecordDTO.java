package com.guest;

public class GuestRecordDTO extends GuestDTO {
	private String g_content;
	private String created;
	
	public String getG_content() {
		return g_content;
	}
	public void setG_content(String g_content) {
		this.g_content = g_content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		
		String str;
		
		str = String.format("%8s %8s %8s ",
				id, g_content, created);
		
		return str;
	}
	
}
