package com.day19;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//이벤트 : 이벤트 단위 프로그램이 돌아가는 과정을 알기 위해서 배우는 내용
//AWT abstract window toolkit > Swing > fx
//extends Frame 얘는 생성자에서 대부분의 준비를 다한다.
//windowlistener : 감시자~ 라고 생각합시다
public class Test1 extends Frame implements WindowListener{
	
	private static final long serialVersionUID=1L;
	
	public Test1() {
		
		setTitle("자바 윈도우");
		setSize(200, 300);
		setBackground(new Color(255, 255, 0));	//컴퓨터 색상은rgb
		
		addWindowListener(this);	//test1에다가 windowlistener를 추가해라
		
		setVisible(true);	//이게 기본적으로 false로 설정되어 있는데  true가 되어야 눈에 보임. 꼭 바꿔주기
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

}
