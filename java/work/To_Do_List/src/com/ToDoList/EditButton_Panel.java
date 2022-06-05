package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EditButton_Panel extends JPanel{

	public EditButton_Panel() {
		//this.setLayout(null);
		//this.setBackground(Color.MAGENTA);
		this.setLayout(new BorderLayout());
		//this.setAlignmentX( Component.RIGHT_ALIGNMENT );
		
		JButton btn = new JButton("...");
		btn.setPreferredSize(new Dimension(20, 5));
		//btn.setFont(new Font("돋움", Font.PLAIN, 20));
		this.add(btn, BorderLayout.WEST);
		
		btn.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3)
					System.out.println("Right Button Pressed");
					if(e.getClickCount() == 2) {
						System.out.println("Double");
				    }
			}        
		});		
		
	}
}
	 


