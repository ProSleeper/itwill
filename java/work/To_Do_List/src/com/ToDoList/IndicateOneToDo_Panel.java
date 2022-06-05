package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

//iotd 한줄씩을 가지고 있을 패널
public class IndicateOneToDo_Panel extends JPanel{
	
	public JCheckBox cb = null;
	public JButton btn = null;
	
	public boolean todo = false;
	public Font strikeFont = null;
	
	public CheckBox_Panel cp = null;
	public EditButton_Panel ep = null;
	
	
	
	public IndicateOneToDo_Panel()  {
		
		this.setBackground(Color.orange);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//this.setLayout(new BorderLayout());
		//this.setLayout(new GridLayout(1, 3));
		JPanel cp = new CheckBox_Panel();
		JPanel ep = new EditButton_Panel();
		
		
		this.add(cp, BorderLayout.WEST);
		this.add(ep, BorderLayout.EAST);
		
		
		
//		cb = new JCheckBox("첫 번째 체크박스");
//		//cb.setHorizontalAlignment(SwingConstants.LEFT);
//		btn = new JButton("수정");
////		
//////		//ip.setAlignmentX(Component.LEFT_ALIGNMENT);
//////		//ip.setOpaque(false);
////		this.add(cb);
////		//this.add(Box.createRigidArea(new Dimension(290, 0)));
////		this.add(btn);
//		
//		cp.add(cb);
//		ep.add(btn);
		
		
		
	}

}


