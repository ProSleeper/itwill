package com.ToDoList;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calendar_Panel extends JPanel {
	
	private Main_Frame mf;
	
	public Calendar_Panel(Main_Frame mf) {
		this.mf = mf;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setLayout(new GridLayout(1,1));
		this.setBackground(Color.white);
		this.setBounds(480, 0, 480, 540);
		
	}
}
