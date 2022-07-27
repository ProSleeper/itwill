package com.ToDoList;

import java.io.Serializable;

public class ToDoList_Object implements Serializable {
	
	private String text;
	private boolean isCheck;
	private int type = -1;
	
	
	public ToDoList_Object(String toDoText) {
		
		text = toDoText;
		isCheck = false;
//		type = xx; 이 부분도 구현해야 하는데 그건 차후에
		
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
		
}