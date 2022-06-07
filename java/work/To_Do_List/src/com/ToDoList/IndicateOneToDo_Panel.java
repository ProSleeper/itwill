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

//iotd ���پ��� ������ ���� �г�
public class IndicateOneToDo_Panel extends JPanel{
	
	JPanel cp;
	JPanel ep;
	
	public IndicateOneToDo_Panel(ToDoList_Object tdo)  {
		
		this.setBackground(Color.orange);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(new TitledBorder(new LineBorder(Color.black)));
		
		cp = new CheckBox_Panel();
		ep = new EditButton_Panel();
		
	
		
		
		this.add(cp, BorderLayout.WEST);
		this.add(ep, BorderLayout.EAST);
		
		
	}
}


