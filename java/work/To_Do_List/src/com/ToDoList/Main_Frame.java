package com.ToDoList;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;


//�� Main_Frame�� �̱���ȭ ���Ѽ� ����ϸ� ���� UIManager������ �ȸ��� �ǰ�����.
//�̷� ������ �´� �ǰ��� �ǹ��� ��� �����Ѵ�.
public class Main_Frame extends JFrame{
		
	static Main_Frame mainFrame;
	static Home_Panel hp;
	static Calendar_Panel cp;
	static CreateToDoList_Normal ctdl;
	
	
	//����������
	public Main_Frame() {
		setLayout(new GridLayout(1, 1));	//�׸��巹�̾ƿ��� ���� ������ ������ �������� ����������. ���� panel�ٿ��� �� �ٿ�����
		setVisible(true);
		setSize(960, 540);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//����Ʈ ���� �̺�Ʈ�� �߻����� �� �� �޼��带 �����ؼ� ��������
	public static void createList(String toDoText) {
		hp.addToDoList(ctdl.createToDoList(toDoText));
	}
	
	
	
	//�̱��� ��ü�� main �Լ��� ������ �־ �ǳ�? �ȵǳ�? �𸣰ڴ�.
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
