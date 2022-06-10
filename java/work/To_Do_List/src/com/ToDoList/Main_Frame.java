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
		
	private Home_Panel hp;
	private Calendar_Panel cp;
	private Scroll_Panel sp;
	
	
	//����������
	public Main_Frame() {
		setLayout(new GridLayout(1, 1));	//�׸��巹�̾ƿ��� ���� ������ ������ �������� ����������. ���� panel�ٿ��� �� �ٿ�����
		setVisible(true);
		setSize(960, 540);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void SetUI() {
//		hp = new Home_Panel();
		sp = new Scroll_Panel();
		cp = new Calendar_Panel();
		
		
		//this.add(hp);
		this.add(sp);
		this.add(cp);
		
		this.setVisible(true);
	}
	
	public Home_Panel getHp() {
		return hp;
	}

	public void setHp(Home_Panel hp) {
		this.hp = hp;
	}

	public Calendar_Panel getCp() {
		return cp;
	}

	public void setCp(Calendar_Panel cp) {
		this.cp = cp;
	}

	public Scroll_Panel getSp() {
		return sp;
	}

	public void setSp(Scroll_Panel sp) {
		this.sp = sp;
	}


	
}
