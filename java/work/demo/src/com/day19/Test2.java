package com.day19;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test2 extends Frame {
	
	public Test2() {
		
		setTitle("윈도우");
		setSize(200,200);
		
		//오버라이드된 메소드는 알아서 실행될테니까 그냥 객체생성해서클래스만 만들어주자
		addWindowListener(new MyWindowAdapter());
		
		setVisible(true);
	}
	
	//z클래스안에 클래스 생성가능
	//내부클래스
	//상속받은 부모클래스를 그대로 쳐도 가능
	class MyWindowAdapter extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
		
		
		
	}
	
	

	public static void main(String[] args) {
		
		new Test2();
		

	}

}
