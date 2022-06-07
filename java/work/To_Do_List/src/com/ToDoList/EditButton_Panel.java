package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EditButton_Panel extends JPanel{
	
	JButton btn;
	
	public EditButton_Panel(JButton btn) {
		this.setLayout(new BorderLayout());
		
		this.btn = btn;
		
		this.add(btn, BorderLayout.EAST);
		btn.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3)
					if(e.getClickCount() == 2) {
				    }
			}        
		});		
		
	}
}
	 


