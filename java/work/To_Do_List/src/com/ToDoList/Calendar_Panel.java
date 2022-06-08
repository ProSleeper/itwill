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
		
		
		//블럭 부분은 테스트를 위한 임시 코드
		/////////////////////////////////////////////////////////////////////////////////////////////
		/**/JButton btn = new JButton("생성");
		/**/this.add(btn);
		/**/
		/**/btn.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
		/**/	public void actionPerformed(ActionEvent e){
		/**/		
		/**/		//JOptionPane.showInputDialog("숫자를 입력하세요");
		/**/		String todoText = JOptionPane.showInputDialog("할일을 입력하세요");
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
