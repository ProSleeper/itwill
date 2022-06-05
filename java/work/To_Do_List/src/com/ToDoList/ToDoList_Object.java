package com.ToDoList;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ToDoList_Object {
	private JCheckBox cb = null;
	private JButton btn = null;
	
	public ToDoList_Object(String toDoText) {
		
		cb = new JCheckBox(toDoText);
		cb.setToolTipText(cb.getText());
		cb.setPreferredSize(new Dimension(420, 50));
		
		btn = new JButton("...");
		
	}
	public void setCheckBox()
	{
		
	}
	public void setButton()
	{
		
	}
	public JCheckBox getCheckBox()
	{
		return cb;
	}
	public JButton getButton()
	{
		return btn;
	}
	
	
}
