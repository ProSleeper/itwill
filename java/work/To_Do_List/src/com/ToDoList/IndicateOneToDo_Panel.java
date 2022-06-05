package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//iotd 한줄씩을 가지고 있을 패널
public class IndicateOneToDo_Panel extends JPanel{
	
	JPanel cp = new CheckBox_Panel();
	JPanel ep = new EditButton_Panel();
	
	public IndicateOneToDo_Panel()  {
		
		this.setBackground(Color.orange);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(new TitledBorder(new LineBorder(Color.black)));
		
		this.add(cp, BorderLayout.WEST);
		this.add(ep, BorderLayout.EAST);
		
		System.out.println(this.getPreferredSize());
		
	}
}


