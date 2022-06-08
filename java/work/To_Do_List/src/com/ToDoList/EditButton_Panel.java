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

		btn.addMouseListener(new MouseAdapter() { //Ŭ���� �̸����� ��� Ŭ���� ����
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					setEditCheckBoxText();
				}
				else if(e.getButton() == MouseEvent.BUTTON3) {
					if(e.getClickCount() == 2) {
						System.out.println("������ ����Ŭ��");
					}
				}
			}
		});
	}

	public void setEditCheckBoxText() {
		Object todoText = JOptionPane.showInputDialog(null, "���� ���ּ���", "����", JOptionPane.DEFAULT_OPTION, null, null, cbp.getText());

		if(todoText != null) {
			if(!todoText.equals("")) {
				cbp.setText(todoText.toString());
			}
		}
	}
}