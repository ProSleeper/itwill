package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EditButton_Panel extends JPanel{
	
	JButton btn = null;
	
	public EditButton_Panel() {
		this.setLayout(new BorderLayout());
		
		btn = new JButton();
		
		this.add(btn, BorderLayout.EAST);
		btn.addMouseListener(new MouseAdapter() { //Ŭ���� �̸����� ��� Ŭ���� ����
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3)
					if(e.getClickCount() == 2) {
				    }
			}        
		});		
		
	}
}
	 


