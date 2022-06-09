package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditButton_Panel extends JPanel{

	JButton btn = null;
	IndicateOneToDo_Panel i_panel = null;

	public EditButton_Panel(IndicateOneToDo_Panel i_panel) {
		this.setLayout(new BorderLayout());

		this.i_panel = i_panel;
		btn = new JButton("...");

		this.add(btn, BorderLayout.EAST);

		btn.addMouseListener(new MouseAdapter() { //Ŭ���� �̸����� ��� Ŭ���� ����
			public void mousePressed(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					setButtonClick();
				}
				else if(e.getButton() == MouseEvent.BUTTON3) {
					if(e.getClickCount() == 2) {
						System.out.println("������ ����Ŭ��");
					}
				}
			}
		});
	}

	public void setButtonClick() {
		 String[] buttons = {"����", "����"};
	        int select = JOptionPane.showOptionDialog(null, "������ �۾��� �����ּ���..", "����, ����",
	                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);
	 
		if(select == 0) {
			setEditCheckBoxText();
		}
		else if(select == 1) {
//			System.out.println("����");
			UIManager.getInstance().toDoDelete(i_panel);
//			
//			this.remove(btn);
//			this.revalidate();
//			this.repaint();
		}
	}
	
	public void setEditCheckBoxText() {
		Object todoText = JOptionPane.showInputDialog(null, "���� ���ּ���", "����", JOptionPane.YES_NO_CANCEL_OPTION, null, null, i_panel.getCp().getText());
		
		if(todoText != null) {
			if(!todoText.equals("")) {
				i_panel.getCp().setText(todoText.toString());
			}
		}
	}
}







