package com.ToDoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;



public class CheckBox_Panel extends JPanel{

	private enum FontType {

		active,
		strike
	}
	private JCheckBox cb = null;

	private Font activeFont;
	private Font completedFont;

	public CheckBox_Panel() {
		this.setLayout(new BorderLayout());
		
		cb = new JCheckBox();
		cb.setBackground(Color.WHITE);
		cb.setToolTipText(cb.getText());
		
		activeFont = FontSelect(FontType.active);
		completedFont = FontSelect(FontType.strike);
		
		cb.setFont(activeFont);
		
		setCheckBoxAddListner();
		cb.setPreferredSize(new Dimension(400, 50));

		this.add(cb, BorderLayout.WEST);
	}

	public String getText()
	{
		return cb.getText();
	}
	
	public void setText(String text) {
		cb.setText(text);
		cb.setToolTipText(text);
	}

	private void setCheckBoxAddListner() {
		cb.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){

				if(cb.isSelected()) {
					cb.setFont(completedFont);
					cb.setBackground(Color.LIGHT_GRAY);
				}
				else {
					cb.setFont(activeFont);
					cb.setBackground(Color.WHITE);
				}
			}
		});
	}

	private Font FontSelect(FontType ft){
		switch (ft) {
		case strike:
			Map attributes = new Font("helvetica", Font.PLAIN, 16).getAttributes();
			attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
			return new Font(attributes);
		case active:
		default:
			return new Font("helvetica", Font.PLAIN, 16);
		}
	}
}




