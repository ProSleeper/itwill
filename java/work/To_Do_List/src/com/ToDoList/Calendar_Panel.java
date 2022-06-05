package com.ToDoList;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calendar_Panel extends JPanel {
	
	private Main_Frame mf;
	
	public Calendar_Panel(Main_Frame mf) {
		this.mf = mf;
		this.setBackground(Color.black);
		//this.setBounds(500, 500, 480, 540);
		JButton btn = new JButton("����");
		this.add(btn);
		
		btn.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e){
				Random rd = new Random();
				//JOptionPane.showInputDialog("���ڸ� �Է��ϼ���");
				mf.createList("�����ϰ� �ֽ��ϴ�." + (rd.nextInt(10) + 1));
			}
		});
	}
}
