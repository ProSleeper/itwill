package com.ToDoList;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main_Frame extends JFrame{
		
	//����������
	public Main_Frame() {
		pack();
		setVisible(true);
		setSize(960, 540);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		Main_Frame mf = new Main_Frame();
		Home_Panel hp = new Home_Panel(mf);
		Calendar_Panel cp = new Calendar_Panel(mf);
		
		mf.add(hp);
		mf.add(cp);
		
		
		
		//�� ��ü���� ��Ʈ���� �г�1
	    //Calendar_Panel cp = new Calendar_Panel(mf);
		

		//hp.initialize(mf);

	}

}
