package com.callback;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class MyPanel extends JPanel implements ActionListener {

	//버튼 선언하기
	JButton addBtn;
	JButton subBtn;
    
	//인터페이스의 주소값을 받기 위함
	MyCallBack callback;
	
	public MyPanel(MyCallBack callback) {
		//interface 
		this.callback = callback;
		
		// 버튼 객체 생성
		addBtn = new JButton("더하기 버튼");
		subBtn = new JButton("빼기 버튼");

		// 레이아웃 및 배경색 설정
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		this.setBackground(Color.BLUE);

		// 패널에 버튼 추가
		this.add(addBtn);
		this.add(subBtn);

		// 이벤트 리스너
		addBtn.addActionListener(this);
		subBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//다운캐스팅
		JButton button = (JButton) e.getSource();
        
		//버튼을 클릭할 경우, 일어나는 이벤트들
		if (button.getText().equals(addBtn.getText())) {
			System.out.println("더하기 버튼 클릭");
			callback.add();  //MyCallBack 인터페이스에 접근하여 add 메소드를 실행
		} else if (button.getText().equals(subBtn.getText())) {
			System.out.println("빼기 버튼 클릭");
			callback.sub();  //MyCallBack 인터페이스에 접근하여 sub 메소드를 실행
		}
	}
}// end of MyPanel