package com.ToDoList;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;

public class Main_Frame extends JFrame{
		
	static Main_Frame mainFrame;
	static Home_Panel hp;
	static Calendar_Panel cp;
	static CreateToDoList_Normal ctdl;
	
	
	//메인프레임
	public Main_Frame() {
		setVisible(true);
		setSize(960, 540);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//리스트 생성 이벤트가 발생했을 때 이 메서드를 실행해서 생성해줌
	public static void createList(String toDoText) {
		hp.addToDoList(ctdl.createToDoList(toDoText));
	}
	
	

	public static void main(String[] args) {
		
		mainFrame = new Main_Frame();
		hp = new Home_Panel(mainFrame);
		cp = new Calendar_Panel(mainFrame);
		ctdl = new CreateToDoList_Normal();
		
		
		mainFrame.add(hp);
		mainFrame.add(cp);
		
		
		Container cn = mainFrame.getContentPane();
		cn.setLayout(new GridLayout(1, 2));
		mainFrame.setVisible(true);

	}

}
