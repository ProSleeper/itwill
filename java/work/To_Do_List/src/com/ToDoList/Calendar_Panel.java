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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Calendar_Panel extends JPanel {
	
	public Calendar_Panel() {
		this.setBackground(Color.black);
		//this.setBounds(500, 500, 480, 540);
		
		
		//�� �κ��� �׽�Ʈ�� ���� �ӽ� �ڵ�
		/////////////////////////////////////////////////////////////////////////////////////////////
		/**/JButton btn = new JButton("����");
		/**/this.add(btn);
		/**/
		/**/btn.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
		/**/	public void actionPerformed(ActionEvent e){
		/**/		
		/**/		//JOptionPane.showInputDialog("���ڸ� �Է��ϼ���");
		/**/		String todoText = JOptionPane.showInputDialog("������ �Է��ϼ���");
		/**/	
		/**/		if(todoText != null && !todoText.equals("")) {
		/**/			DataManager.getInstance().createData(todoText);
		/**/			UIManager.getInstance().createToDoPanel();
		/**/		}
		/**/	}
		/**/});
		/////////////////////////////////////////////////////////////////////////////////////////////
	}
}
