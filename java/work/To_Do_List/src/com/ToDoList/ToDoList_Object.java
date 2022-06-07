package com.ToDoList;

import java.time.LocalDate;

public class ToDoList_Object {
	
	private String text;
	private boolean isCheck;
	private int[] date;
	private int type = -1;
	
	
	public ToDoList_Object(String toDoText) {
		
		text = toDoText;
		isCheck = false;
		date = new int[3];
//		type = xx; �� �κе� �����ؾ� �ϴµ� �װ� ���Ŀ�
		
		// ���� ��¥ ���ϱ�        
		LocalDate now = LocalDate.now();
		date[0] = now.getYear();
		date[1] = now.getMonthValue();
		date[2] = now.getDayOfMonth();
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


	public int[] getDate() {
		return date;
	}


	public void setDate(int[] date) {
		this.date = date;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
	
}