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
		setLayout(new GridLayout(1, 1));	//그리드레이아웃은 딱히 설정의 제한이 강력하지 않은가보다. 대충 panel붙여도 다 붙여지네
		setVisible(true);
		setSize(960, 540);
		setResizable(true);
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
		
		//Container cn = mainFrame.getContentPane();
		//cn.setLayout(new GridLayout(1, 1));
		mainFrame.setVisible(true);

	}

}
