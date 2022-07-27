package com.day19;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test3 extends Frame {
	
	public Test3() {
		
		setTitle("윈도우");
		setSize(200,200);
		
		//오버라이드된 메소드는 알아서 실행될테니까 그냥 객체생성해서클래스만 만들어주자
		//무명의 클래스
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
			System.exit(0);
			}
		});	//종료버튼 코딩 이렇게 하기
		
		setVisible(true);
	}
	
	
	
	

	public static void main(String[] args) {
		
		new Test3();
		

	}

}
