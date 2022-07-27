package com.callback;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class MyPanel extends JPanel implements ActionListener {

	//��ư �����ϱ�
	JButton addBtn;
	JButton subBtn;
    
	//�������̽��� �ּҰ��� �ޱ� ����
	MyCallBack callback;
	
	public MyPanel(MyCallBack callback) {
		//interface 
		this.callback = callback;
		
		// ��ư ��ü ����
		addBtn = new JButton("���ϱ� ��ư");
		subBtn = new JButton("���� ��ư");

		// ���̾ƿ� �� ���� ����
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		this.setBackground(Color.BLUE);

		// �гο� ��ư �߰�
		this.add(addBtn);
		this.add(subBtn);

		// �̺�Ʈ ������
		addBtn.addActionListener(this);
		subBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�ٿ�ĳ����
		JButton button = (JButton) e.getSource();
        
		//��ư�� Ŭ���� ���, �Ͼ�� �̺�Ʈ��
		if (button.getText().equals(addBtn.getText())) {
			System.out.println("���ϱ� ��ư Ŭ��");
			callback.add();  //MyCallBack �������̽��� �����Ͽ� add �޼ҵ带 ����
		} else if (button.getText().equals(subBtn.getText())) {
			System.out.println("���� ��ư Ŭ��");
			callback.sub();  //MyCallBack �������̽��� �����Ͽ� sub �޼ҵ带 ����
		}
	}
}// end of MyPanel