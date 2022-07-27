package com.callback;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame implements MyCallBack {
	//label 선언
	JLabel label;
    
	//객체의 주소값을 받기 위함
	MyPanel myPanel;

	//생성자
	public MyFrame() {
		initData();
		setInitLayout();
	}

	//initData 메소드
	private void initData() {
		setTitle("Button Click Event");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Hello, ");

		//MyPanel 생성자에 MyCallBack 매개변수가 있기 때문에 this를 참조변수로 넣어줌
		//this를 사용해도 되는 이유 : MyFrame 클래스에서 MyCallBack을 implements 했기 때문.
		myPanel = new MyPanel(this);
        
		myPanel.setPreferredSize(new Dimension(500, 300));
	}// end of initDate

	//setInitLayout 메소드
	private void setInitLayout() {
		setVisible(true);
		setLayout(new BorderLayout());
		this.add(label, BorderLayout.NORTH);
		this.add(myPanel, BorderLayout.SOUTH);
	}// end of setInitLayout
	
	//오버라이딩
	@Override
	public void add() {
		label.setText("더하기 버튼 클릭, 화면에 표시됨!");
		//label에 접근하여 표시되는 텍스트를 변경
	}

	@Override
	public void sub() {
		label.setText("빼기 버튼 클릭, 화면에 표시됨!");
		//label에 접근하여 표시되는 텍스트를 변경
	}
}
