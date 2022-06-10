package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//iotd ���پ��� ������ ���� �г�
public class IndicateOneToDo_Panel extends JPanel{

	private JCheckBox jcb = null;
	private JButton jb = null;

	private Font activeFont;
	private Font completedFont;

	public IndicateOneToDo_Panel(String toDoText)  {
		this.setLayout(new BorderLayout());
		//		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(new TitledBorder(new LineBorder(Color.black)));

		jcb = new JCheckBox();
		jb = new JButton("...");
		
		jcb.setMaximumSize(new Dimension(Integer.MAX_VALUE, jcb.getMinimumSize().height));
		
		

		activeFont = Assistant_Data.FontSelect("active");
		completedFont = Assistant_Data.FontSelect("strike");
		
		setCheckBoxAddListner();
		setButtonAddListener();
		
		jcb.setFont(activeFont);
		jcb.setBackground(Color.WHITE);
		jcb.setText(toDoText);

		this.add(jcb, BorderLayout.WEST);
		this.add(jb, BorderLayout.EAST);
	}

	public void setEditCheckBoxText() {
		Object todoText = JOptionPane.showInputDialog(null, "���� ���ּ���", "����", JOptionPane.YES_NO_CANCEL_OPTION, null, null, jcb.getText());
		
		if(todoText != null) {
			if(!todoText.equals("")) {
				jcb.setText(todoText.toString());
			}
		}
	}
	
	public void setButtonAddListener() {
		jb.addMouseListener(new MouseAdapter() { //Ŭ���� �̸����� ��� Ŭ���� ����
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
			UIManager.getInstance().toDoDelete(this);
			//			
			//			this.remove(btn);
			//			this.revalidate();
			//			this.repaint();
		}
	}

	private void setCheckBoxAddListner() {
		jcb.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e){

				if(jcb.isSelected()) {
					jcb.setFont(completedFont);
					jcb.setBackground(Color.LIGHT_GRAY);
				}
				else {
					jcb.setFont(activeFont);
					jcb.setBackground(Color.WHITE);
				}
			}
		});
	}
}
