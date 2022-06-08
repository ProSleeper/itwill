package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditButton_Panel extends JPanel{

	JButton btn = null;
	CheckBox_Panel cbp = null;

	public EditButton_Panel(CheckBox_Panel cp) {
		this.setLayout(new BorderLayout());

		cbp = cp;
		btn = new JButton("...");

		this.add(btn, BorderLayout.EAST);

		btn.addMouseListener(new MouseAdapter() { //클래스 이름없이 어뎁터 클래스 생성
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					setEditCheckBoxText();
				}
				else if(e.getButton() == MouseEvent.BUTTON3) {
					if(e.getClickCount() == 2) {
						System.out.println("오른쪽 더블클릭");
					}
				}
			}
		});
	}

	public void setEditCheckBoxText() {
		Object todoText = JOptionPane.showInputDialog(null, "수정 해주세요", "수정", JOptionPane.DEFAULT_OPTION, null, null, cbp.getText());

		if(todoText != null) {
			if(!todoText.equals("")) {
				cbp.setText(todoText.toString());
			}
		}
	}
}