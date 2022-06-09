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
	
	private CheckBox_Panel cp = null;
	private EditButton_Panel ep = null;
	
	public IndicateOneToDo_Panel(String toDoText)  {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(new TitledBorder(new LineBorder(Color.black)));
		
		cp = new CheckBox_Panel();
		ep = new EditButton_Panel(this);
		
		cp.setText(toDoText);
		
		this.add(cp, BorderLayout.WEST);
		this.add(ep, BorderLayout.EAST);
	}
	
	public CheckBox_Panel getCp() {
		return cp;
	}

	public void setCp(CheckBox_Panel cp) {
		this.cp = cp;
	}

	public EditButton_Panel getEp() {
		return ep;
	}

	public void setEp(EditButton_Panel ep) {
		this.ep = ep;
	}
}
