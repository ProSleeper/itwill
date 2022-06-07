package com.ToDoList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class ToDoList_Object {
	private JCheckBox cb = null;
	private JButton btn = null;
	
	private boolean todo = false;
	
	private Font activeFont = null;
	private Font completedFont = null;
	
	
	public ToDoList_Object(String toDoText) {
		
		checkboxCreate(toDoText);
		buttonCreate();
		setColor(Color.WHITE);
		
		
		
		//배경색 변경 나중에 다른 부분으로 이동
//		cb.setBackground(Color.LIGHT_GRAY);
//		btn.setBackground(Color.LIGHT_GRAY);
	}
	public void setCheckBox(){
		
	}
	public void setButton(){
		
	}
	public JCheckBox getCheckBox(){
		return cb;
	}
	public JButton getButton(){
		return btn;
	}
	
	void checkboxCreate(String toDoText) {
		cb = new JCheckBox(toDoText);
		cb.setToolTipText(cb.getText());
		cb.setPreferredSize(new Dimension(420, 50));
		setCheckBoxAddListner();
		strikeFontApply();
	}
	
	void buttonCreate() {
		btn = new JButton("...");
		//지금은 딱히 코드가 없지만 나중에 버튼 클릭시 필요한 부분 코드가 생성될듯
		setButtonAddListner();
	}
	
	void strikeFontApply(){
		Map attributes = new Font("helvetica", Font.PLAIN, 12).getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		completedFont = new Font(attributes);
	}
	
	
	
	void setCheckBoxAddListner() {
		cb.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){

				if(cb.isSelected()) {
					cb.setFont(completedFont);
					setColor(Color.LIGHT_GRAY);
				}
				else {
					cb.setFont(activeFont);
					setColor(Color.WHITE);
				}
			}
		});
	}
	
	void setButtonAddListner() {
		btn.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				
				String[] buttons = { "수정", "삭제"};

				int num = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.DEFAULT_OPTION, null, buttons, null);
				if(num == 0) {
					setEditCheckBoxText();
				}
				else {
					
				}
			}
		});
	}
	
	void setEditCheckBoxText() {
		Object todoText = JOptionPane.showInputDialog(null, "수정 해주세요", "수정", JOptionPane.DEFAULT_OPTION, null, null, cb.getText());
		
		if(todoText != null) {
			if(!todoText.equals("")) {
				cb.setText(todoText.toString());
			}
		}
	}
	
	void setColor(Color color) {
		cb.setBackground(color);
		btn.setBackground(color);
	}
}
