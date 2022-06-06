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
	
	public boolean todo = false;
	public Font strikeFont = null;
	
	
	public ToDoList_Object(String toDoText) {
		
		cb = new JCheckBox(toDoText);
		cb.setToolTipText(cb.getText());
		cb.setPreferredSize(new Dimension(420, 50));
		btn = new JButton("...");
		
		strikeFont = new Font("helvetica", Font.PLAIN, 12);
		Map attributes = strikeFont.getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		Font newFont = new Font(attributes); 
		
		setCheckBoxAddListner();
		
		cb.setFont(newFont);
		
		//6ø˘ 7¿œ¿∫ ¿Ã ∫Œ∫–∫Œ≈Õ ¡¯«‡.
		//
		
		cb.setBackground(Color.LIGHT_GRAY);
		btn.setBackground(Color.LIGHT_GRAY);
	}
	public void setCheckBox()
	{
		
	}
	public void setButton()
	{
		
	}
	public JCheckBox getCheckBox()
	{
		return cb;
	}
	public JButton getButton()
	{
		return btn;
	}
	
	void setCheckBoxAddListner() {
		cb.addActionListener(new ActionListener(){ //¿Õ∏Ì≈¨∑°Ω∫∑Œ ∏ÆΩ∫≥  ¿€º∫
			public void actionPerformed(ActionEvent e){

				if(cb.isSelected()) {
					System.out.println("√º≈©");
				}
				else {
					System.out.println("noÆG");
				}
				
			}
		});
	}
	
}
