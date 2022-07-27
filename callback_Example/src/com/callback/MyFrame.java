package com.callback;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyFrame extends JFrame implements MyCallBack {
	//label ����
	JLabel label;
    
	//��ü�� �ּҰ��� �ޱ� ����
	MyPanel myPanel;

	//������
	public MyFrame() {
		initData();
		setInitLayout();
	}

	//initData �޼ҵ�
	private void initData() {
		setTitle("Button Click Event");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Hello, ");

		//MyPanel �����ڿ� MyCallBack �Ű������� �ֱ� ������ this�� ���������� �־���
		//this�� ����ص� �Ǵ� ���� : MyFrame Ŭ�������� MyCallBack�� implements �߱� ����.
		myPanel = new MyPanel(this);
        
		myPanel.setPreferredSize(new Dimension(500, 300));
	}// end of initDate

	//setInitLayout �޼ҵ�
	private void setInitLayout() {
		setVisible(true);
		setLayout(new BorderLayout());
		this.add(label, BorderLayout.NORTH);
		this.add(myPanel, BorderLayout.SOUTH);
	}// end of setInitLayout
	
	//�������̵�
	@Override
	public void add() {
		label.setText("���ϱ� ��ư Ŭ��, ȭ�鿡 ǥ�õ�!");
		//label�� �����Ͽ� ǥ�õǴ� �ؽ�Ʈ�� ����
	}

	@Override
	public void sub() {
		label.setText("���� ��ư Ŭ��, ȭ�鿡 ǥ�õ�!");
		//label�� �����Ͽ� ǥ�õǴ� �ؽ�Ʈ�� ����
	}
}
