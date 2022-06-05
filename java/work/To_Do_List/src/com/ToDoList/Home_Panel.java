package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Home_Panel extends JPanel{

	private Main_Frame mf;
	private final int MAXLABELCOUNT = 10;

	public Home_Panel(Main_Frame mf)  {
		this.mf = mf;
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(0, 0, 480, 520);
		//this.setLayout(new GridLayout(MAXLABELCOUNT,1));

		JCheckBox[] lb = new JCheckBox[30];


		//		for (int i = 0; i < MAXLABELCOUNT; i++) {
		//			lb[i] = new JCheckBox();
		//			
		//			//lb[i].setSize(100, 50);
		//			this.add(lb[i]);
		//			//lb[i].setSize(100, 50);
		//		}
		this.setAutoscrolls(true);


		Container cn = mf.getContentPane();
		//Set up the content pane.
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//	      lb.setHorizontalAlignment(SwingConstants.LEFT);

		
		for (int i = 0; i < 11; i++) {
			lb[i] = new JCheckBox((i+1) + " 번째");
			lb[i].setAlignmentX(Component.LEFT_ALIGNMENT);
			this.add(lb[i]);
			
		}

		cn.add(this);



		//		lb.setBounds(200,0, 100, 100);
		//		lb2.setBounds(100, 0, 100, 100);

		//		this.add(lb);
		//		this.add(lb2);
	}

	void initialize(JFrame mainFrame) {
		//		JPanel panel = new JPanel();
		//
		////		add(panel);
		//		JLabel label = new JLabel("텍스트를 입력하시오.");
		//		
		//		panel.setLayout(new BorderLayout());
		//		panel.add(label, BorderLayout.NORTH);
		//		mainFrame.add(this);
		//		System.out.println("애드애드");
	}

}


