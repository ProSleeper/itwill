package com.ToDoList;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;


//이 Main_Frame을 싱글턴화 시켜서 사용하면 굳이 UIManager같은거 안만들어도 되겠지만.
//이런 형식이 맞는 건가의 의문은 계속 존재한다.
public class Main_Frame extends JFrame{
		
	private Home_Panel hp;
	private Calendar_Panel cp;
	private Scroll_Panel sp;
	
	
	//메인프레임
	public Main_Frame() {
		setLayout(new GridLayout(1, 1));	//그리드레이아웃은 딱히 설정의 제한이 강력하지 않은가보다. 대충 panel붙여도 다 붙여지네
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
