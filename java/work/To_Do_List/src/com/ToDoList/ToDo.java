package com.ToDoList;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public abstract class ToDo {
	
	
	
	public ToDo() {
	}
	
	abstract ToDoList_Object createToDoList(String toDoText);
	

}
